package com.crawler.seller.taobao.pagecrawler;

import com.crawler.seller.taobao.tools.HttpTools;
import com.crawler.seller.taobao.tools.RegexTools;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: taobao
 * @Description: 爬取商家信息的爬虫，主要爬去商家的商品Url
 * @author: Mr.gao
 * @create: 2019-04-24 15:45
 * @email: 630268696@qq.com
 **/
@RestController
@RequestMapping("/crawler")
public class SellerPageCrawler {
    @Autowired
    GoodsPageCrawler goodsPageCrawler;

    final static String hostUrlSplit = ".com";
    static HttpTools httpTools = HttpTools.getInstance();
    static String goodsUrlBegins = "https://item.taobao.com/item.htm?";
    @PostMapping("/crawlerSeller")
    public String getGoodsBySellerUrl(String sellerUrl){
        String allGoodsUrlBegins = goodsUrlBegins+ sellerUrl.split("\\?")[1];
        System.out.println(allGoodsUrlBegins);
        Document document = httpTools.getDocumentByJSoupGet(sellerUrl);
        Elements elements = document.getElementsByClass("cat-name fst-cat-name");
        for(Element element:elements){
            String goodsClassifyUrl = HttpTools.httpTag+element.attr("href");
            //System.out.println(goodsClassifyUrl);
            String goodsClassify = element.text();
            if(goodsClassify.equals("所有宝贝")){

            }else{
                List<String> goodsIdList = getGoodsByClassifyAndSellerUrl(goodsClassifyUrl);
                for(String string:goodsIdList){
                    String goodsReallyUrl = allGoodsUrlBegins+"&id="+string;
                    System.out.println(goodsReallyUrl);
                    goodsPageCrawler.getGoodsInfo(goodsReallyUrl,goodsClassify,0);
                }
            }
        }

        return "success";
    }

    public static List<String> getGoodsByClassifyAndSellerUrl(String classifyUrl){
        StringBuilder hostUrl = new StringBuilder();
        hostUrl.append(classifyUrl.split(hostUrlSplit)[0]+hostUrlSplit);
        //为了获取该店铺下某属性全部商品内容
        Document document = httpTools.getDocumentByJSoupGet(classifyUrl);
        Element element = document.getElementById("J_ShopAsynSearchURL");
        String picUrl = element.attr("value");
        hostUrl.append(picUrl);
        //分类商品Url构造完成,通过解析获得对应商品的Id
        String classifyGoods = httpTools.getDocumentByOkHttpClientForClassifyUrl(hostUrl.toString());
        String[] findIdWithoutDocument = classifyGoods.split("data-id=");
        List<String> goodsIdList = new ArrayList<>();
        for(String string:findIdWithoutDocument){
            String goodsId = RegexTools.getNumberFromStringBegins(string);
            if(goodsIdList.contains(goodsId)||goodsId.equals("")){
                continue;
            }
            goodsIdList.add(goodsId);
        }
        //System.out.println(document);
        return goodsIdList;
    }

    public static void main(String[] args){
        String sellerUrl = "https://shop104897509.taobao.com/?spm=a230r.7195193.1997079397.2.c7c515901pEdmT";
        //String classifyUrl = "https://lol7m.taobao.com/category-747472620.htm?search=y&catName=%CA%F3%B1%EA";
        //getGoodsByClassifyAndSellerUrl(classifyUrl);
        //getGoodsBySellerUrl(sellerUrl);
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            String partString = scanner.next();
//            System.out.println(removeAmpFromUrl(partString));
//        }
    }
}
