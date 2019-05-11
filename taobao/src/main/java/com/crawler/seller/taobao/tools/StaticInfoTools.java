package com.crawler.seller.taobao.tools;

import java.util.Scanner;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-29 10:39
 * @email: 630268696@qq.com
 **/
public class StaticInfoTools {

    public static String brand = "品牌";
    public static String classify = "型号";

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String inputStr = scanner.next();
            String[] strings = inputStr.split(";");
            for(String string:strings){
                System.out.println(string);
            }
        }
    }
}
