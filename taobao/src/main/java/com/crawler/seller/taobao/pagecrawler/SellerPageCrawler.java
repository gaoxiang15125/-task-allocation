package com.crawler.seller.taobao.pagecrawler;

import com.crawler.seller.taobao.tools.HttpTools;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;

/**
 * @program: taobao
 * @Description: 爬取商家信息的爬虫，主要爬去商家的商品Url
 * @author: Mr.gao
 * @create: 2019-04-24 15:45
 * @email: 630268696@qq.com
 **/
public class SellerPageCrawler {
    static HttpTools httpTools = HttpTools.getInstrance();

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
        Document document = httpTools.getDocumentByJSoupGet(classifyUrl);
        System.out.println(document);
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
