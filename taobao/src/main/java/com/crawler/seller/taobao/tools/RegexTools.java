package com.crawler.seller.taobao.tools;

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
    public static void main(String[]args){
        getRegexKeyValueFromJSON(JsonTest.testJson,"descUrl");
    }
}
