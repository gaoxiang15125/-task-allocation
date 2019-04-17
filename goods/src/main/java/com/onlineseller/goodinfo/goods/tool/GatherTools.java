package com.onlineseller.goodinfo.goods.tool;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-17 17:23
 * @email: 630268696@qq.com
 **/
public class GatherTools {
    /**
     *
     * @param stringList 功能看名字，之后就不写注释了
     * @return
     */
    public static String ListToString(List<String> stringList){
        StringBuilder stringBuilder =new StringBuilder();
        for(String string:stringList){
            stringBuilder.append(string+";");
        }
        return stringBuilder.toString();
    }

    public static String StringToList(String listString){

    }
}
