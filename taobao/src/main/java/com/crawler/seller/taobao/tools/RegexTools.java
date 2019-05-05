package com.crawler.seller.taobao.tools;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: taobao
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-23 15:27
 * @email: 630268696@qq.com
 **/
public class RegexTools {

    /**
     * 从此处活活得对Url的匹配，我觉得还是把他变成map算了
     * @param jsonString
     * @param param
     * @return
     */
    public static String getRegexKeyValueFromJSON(String jsonString,String param){
        // 匹配规则是当avatar是{}包装的对象

        String result = "";
        Pattern mPAvatar = Pattern.compile("([a-z]*)");
        Matcher mMAvatar = mPAvatar.matcher(jsonString);
        while (mMAvatar.find()) {// 如果找到 开始替换
            result = mMAvatar.group();
        }
        return result;
    }

    /**
     * @param goodsUrl 包含&amp;的url字符串
     * @return 清除amp;的url字符串
     */
    public static String removeAmpFromUrl(String goodsUrl){
        return goodsUrl.replaceAll("amp;","");
    }

    /**
     * 从字符串中提取Id
     * @param numberContainString 以数字开头的字符串
     * @return 从字符串里提取的id，为空返回null
     */
    public static String getNumberFromStringBegins(String numberContainString){
        StringBuilder stringBuilder = new StringBuilder();
        char buff;
        //过滤长度不符合条件的字符串
        if(numberContainString.length()<3){
            return null;
        }
        for(int i=2;i<numberContainString.length();i++){
            //sout 开销居然如此大，不用sout瞬间超出内存，增加sout等待很久溢出内存
            buff = numberContainString.charAt(i);
            if(((buff >= '0') && (buff <= '9')) || (buff ==' ')){
                stringBuilder.append(buff);
            }else{
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[]args){
        //getRegexKeyValueFromJSON(JsonTest.testJson,"descUrl");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String inputStr = scanner.next();
            //System.out.println(inputStr);
            System.out.println(getNumberFromStringBegins(inputStr));
        }
    }
}
