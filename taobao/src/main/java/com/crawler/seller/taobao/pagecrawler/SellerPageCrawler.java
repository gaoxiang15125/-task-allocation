package com.crawler.seller.taobao.pagecrawler;

import com.crawler.seller.taobao.tools.HttpTools;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @program: taobao
 * @Description: 爬取商家信息的爬虫，主要爬去商家的商品Url
 * @author: Mr.gao
 * @create: 2019-04-24 15:45
 * @email: 630268696@qq.com
 **/
public class SellerPageCrawler {
    final static String hostUrlSplit = ".com";
    static HttpTools httpTools = HttpTools.getInstance();

    public static String getGoodsBySellerUrl(String sellerUrl){
        Document document = httpTools.getDocumentByJSoupGet(sellerUrl);
        Elements elements = document.getElementsByClass("cat-name fst-cat-name");
        for(Element element:elements){
            String goodsClassifyUrl = element.attr("href");
            String goodsClassify = element.text();
            if(goodsClassify.equals("所有宝贝")){

            }else{

            }
        }

        return null;
    }

    public static String getGoodsByClassifyAndSellerUrl(String classifyUrl){
        StringBuilder hostUrl = new StringBuilder();
        hostUrl.append(classifyUrl.split(hostUrlSplit)[0]+hostUrlSplit);
        //为了获取该店铺下某属性全部商品内容
        Document document = httpTools.getDocumentByJSoupGet(classifyUrl);
        Element element = document.getElementById("J_ShopAsynSearchURL");
        String picUrl = element.attr("value");
        hostUrl.append(picUrl);
        //分类商品Url构造完成
        document = httpTools.getDocumentByJSoupPost(hostUrl.toString());
        System.out.println(document);
        System.out.println(hostUrl.toString());
        return null;
    }

    public static void main(String[] args){
        String sellerUrl = "https://shop104897509.taobao.com/?spm=a230r.7195193.1997079397.2.c7c515901pEdmT";
        String classifyUrl = "https://lol7m.taobao.com/category-747472620.htm?search=y&catName=%CA%F3%B1%EA";
        getGoodsByClassifyAndSellerUrl(classifyUrl);

        //        getGoodsBySellerUrl(sellerUrl);
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            String partString = scanner.next();
//            System.out.println(removeAmpFromUrl(partString));
//        }
    }
}
