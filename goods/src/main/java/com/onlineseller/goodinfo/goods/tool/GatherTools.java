package com.onlineseller.goodinfo.goods.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-17 17:23
 * @email: 630268696@qq.com
 **/
public class GatherTools {

    public static String picUrlTag = ";";
    public static String standardTag = "-";
    /**
     *
     * @param stringList 功能看名字，之后就不写注释了
     * @return
     */
    public static String ListToString(List<String> stringList,String tag){
        StringBuilder stringBuilder =new StringBuilder();
        for(String string:stringList){
            stringBuilder.append(string+tag);
        }
        return stringBuilder.toString();
    }

    /**
     * @param listString 需要进行分割的字符串
     * @param tag 目标分割
     * @return
     */
    public static ArrayList<String> StringToList(String listString, String tag){
        String[] lists = listString.split(tag);
        ArrayList<String> arrayList = new ArrayList<>();
        for(String str:lists){
            arrayList.add(str);
        }
        return arrayList;
    }
}
