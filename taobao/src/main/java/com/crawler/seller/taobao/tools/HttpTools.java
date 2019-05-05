package com.crawler.seller.taobao.tools;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
    //现存的cookie header信息实例，通过map解析使用
    final static String headersAndCookie = "Connection: keep-alive\n" +
            "Accept: text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01\n" +
            "X-Requested-With: XMLHttpRequest\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36\n" +
            "Referer: https://lol7m.taobao.com/category-747472627.htm?spm=a1z10.5-c.w4010-2445375158.8.f1ca487crZNhNK&search=y&catName=%BC%FC%C5%CC\n" +
            "Accept-Encoding: gzip, deflate, br\n" +
            "Accept-Language: zh-CN,zh;q=0.9\n" +
            "Cookie: thw=cn; v=0; t=2b091bb69d691a0b281a80bc1a5f6587; cookie2=1c944402217feb3f1efb7a8047913c8a; _tb_token_=3773bee35f50e; cna=A0v6FHJpYwgCAdpen2KLzEej; tracknick=%5Cu9AD8%5Cu7FD4125gx; dnk=%5Cu9AD8%5Cu7FD4125gx; tg=0; enc=B8%2Bl4VQn8v6tl%2FPh0Owu3uqrNUCtcV4LmabCMwleh4FWaHYwZ5NT8NRobTBrJamUhkMwxDN4NDVDZqJF8PnHNA%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; x=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0%26__ll%3D-1%26_ato%3D0; whl=-1%260%260%261551073993408; skt=d5d2aeab2a1e24d4; csg=22c87f3f; existShop=MTU1MjAwNjIxMg%3D%3D; _cc_=W5iHLLyFfA%3D%3D; uc1=cookie16=WqG3DMC9UpAPBHGz5QBErFxlCA%3D%3D&cookie21=UtASsssmeW6lpyd%2BB%2B3t&cookie15=VT5L2FSpMGV7TQ%3D%3D&existShop=false&pas=0&cookie14=UoTZ4Mz2NWsNTw%3D%3D&cart_m=0&tag=8&lng=zh_CN; mt=ci%3D-1_1; ali_ab=218.94.159.98.1556591243309.6; _m_h5_tk=f9be5088a156654c62a1a659ed3f9497_1556601325138; _m_h5_tk_enc=61b3d233fb4c621a2ee609c230b47414; pnm_cku822=098%23E1hvsvvUvbpvUvCkvvvvvjiPRLdOQjYUnLz91j1VPmPUQjlbPLqv6j18RFzwgj1RiQhvCvvv9U8EvpvVmvvC9jaHuphvmvvv92Z%2Bsbv6Kphv8vvvvvCvpvvvvvvmj6Cv22GvvUnvphvpgvvv96CvpC29vvm2phCvhRvEvpCWmWwkvvw%2F6WmQ0fJ6EvLvqU0HKfE97JFEDaVTRogRD7zhz8Tx46JDYn29VCi%2BVd0DyOvO5onmsX7v1C9aWDNBlwethbUf8c7%2Bdbm659hCvvOvCvvvphvPvpvhvv2MMsyCvvpvvvvv; l=bBPpjT2PvoSpGTBMBOCgVuIJ6X79jIRAguPRwMg9i_5Bz6L1My_OlQmvyFp6Vj5R__8p4-L8Y1y9-etks; isg=BP39iVfkfdtMB9mDrrmrOV35DFk3Mh4bFmrYqb9COtSC9h0ohuoWvMOooGoV9kmk";
    private OkHttpClient okHttpClient;

    public static HttpTools httpTools = new HttpTools();

    private HttpTools(){
        //构造基本的headers 与cookie信息
        okHttpClient =new OkHttpClient();
    }

    public static HttpTools getInstance(){
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
    //下面是附带请求头与基本cookie的Url请求
    public Document getDocumentByOkHttpClientForClassifyUrl(String stringUrl){
        Request.Builder request = new Request.Builder().url(stringUrl);
        Map<String,String> headers = getHeadsAndCookieMap(headersAndCookie);
        for(String string:headers.keySet()){
            request.addHeader(string,headers.get(string));
        }
        return new Document(okHttpGet(request.build()));
    }

    /**
     * @param request
     * @return 需要使用GZIP进行处理，没办法网络通讯就认准GZIP
     */
    public static String okHttpGet(Request request){
        OkHttpClient httpClient = new OkHttpClient();
        Response response = null;
        byte[] responseString = null;
        try {
            response = httpClient.newCall(request).execute();
            // 返回的是string 类型，json的mapper可以直接处理
            responseString = response.body().bytes();
        } catch (IOException e) {
            System.out.println("出现Url访问错误");
            e.printStackTrace();
        }
        String goodsList = GzipTools.uncompressString(responseString);
        //System.out.println(goodsList);
        String[] findIdWithoutDocument = goodsList.split("data-id=");
        Map<String,String> resultId = new HashMap<>();
        for(String string:findIdWithoutDocument){
            RegexTools.getNumberFromStringBegins(string);
        }
        return goodsList;
    }

    private static HashMap<String,String> getHeadsAndCookieMap(String headsString){
        String[] urlLists = headsString.split("\n");
        String[] mapAttribute;
        HashMap<String,String> hashMap = new HashMap<>();
        for(String string:urlLists){
            mapAttribute = string.split(": ");
            hashMap.put(mapAttribute[0],mapAttribute[1]);
        }
        return hashMap;
    }

    public static void main(String[]args){
        HttpTools httpTools = HttpTools.getInstance();
        String classifyUrl = "https://lol7m.taobao.com/i/asynSearch.htm?mid=w-2445375159-0&wid=2445375159&path=/category-747472620.htm&search=y&catName=%CA%F3%B1%EA&catId=747472620&scid=747472620";
        System.out.println(httpTools.getDocumentByOkHttpClientForClassifyUrl(classifyUrl));
        //知其不可而为之
//        String url = "http://dsc.taobaocdn.com/i2/580/170/585174273980/TB1nMYNzxTpK1RjSZFM8qvG_Vla.desc%7Cvar%5Edesc%3Bsign%5Edb3e3a289828ba0d5ae4c937ad932abe%3Blang%5Egbk%3Bt%5E1551679747\n";
//        System.out.println(httpTools.getDocumentByJSoupGet(url));
    }
}
