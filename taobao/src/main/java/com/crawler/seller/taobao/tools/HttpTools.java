package com.crawler.seller.taobao.tools;

import com.crawler.seller.taobao.pagecrawler.GoodsPageCrawler;
import okhttp3.OkHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: taobao
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-22 17:01
 * @email: 630268696@qq.com
 **/
public class HttpTools {
    //静态链接标签值
    public static String picLinkTag = ";";
    public static String httpTag = "http:";

    private OkHttpClient okHttpClient;

    public static HttpTools httpTools = new HttpTools();

    private HttpTools(){
        okHttpClient =new OkHttpClient();
    }

    public static HttpTools getInstrance(){
        return httpTools;
    }

    /**
     * 估计淘宝不会这么容易获得document
     * @param url
     * @return
     */
    public Document getDocumentByJSoupGet(String url){
        Document document = null;
        try {
            //获取整个网站的根节点，也就是html开头部分一直到结束
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("爬取网页信息失败");
            e.printStackTrace();
        }
        return document;
    }

    public Document getDocumentByJSoupPost(String url){
        Document document = null;
        try {
            //获取整个网站的根节点，也就是html开头部分一直到结束
            document = Jsoup.connect(url).post();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("爬取网页信息失败");
            e.printStackTrace();
        }
        return document;
    }
    //既然这样就可以，那就不用OkHttp了

//    public static void main(String[]args){
//        HttpTools httpTools = HttpTools.getInstrance();
//        Document document = httpTools.getDocumentByJSoupGet("https://desc.alicdn.com/i2/580/170/585174273980/TB1nMYNzxTpK1RjSZFM8qvG_Vla.desc%7Cvar%5Edesc%3Bsign%5Edb3e3a289828ba0d5ae4c937ad932abe%3Blang%5Egbk%3Bt%5E1551679747");
//        Elements elements = GoodsPageCrawler.picUrlFinder(document);
//        List<String> picUrl = new ArrayList<>();
//        for(int i=0;i<elements.size();i++){
//            String tag = elements.get(i).attr("class");
//            if(tag.equals("desc_anchor")){
//                continue;
//            }
//            System.out.println(tag);
//            picUrl.add(elements.get(i).attr("src"));
////            if(i!=elements.size()-1){
////                picUrl.add(picLinkTag);
////            }
//        }
//        System.out.println();
//        for (String string:picUrl){
//            System.out.println(string);
//        }
//        //Element element=document.getElementById("J_DivItemDesc");
//        //System.out.println(element.toString());
//    }
    public static void main(String[]args){
        HttpTools httpTools = HttpTools.getInstrance();
        //知其不可而为之
        String url = "http://dsc.taobaocdn.com/i2/580/170/585174273980/TB1nMYNzxTpK1RjSZFM8qvG_Vla.desc%7Cvar%5Edesc%3Bsign%5Edb3e3a289828ba0d5ae4c937ad932abe%3Blang%5Egbk%3Bt%5E1551679747\n";
        System.out.println(httpTools.getDocumentByJSoupGet(url));
    }
}
