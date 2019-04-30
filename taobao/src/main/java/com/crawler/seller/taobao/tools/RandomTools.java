package com.crawler.seller.taobao.tools;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-29 09:12
 * @email: 630268696@qq.com
 **/
public class RandomTools {
    static Random r=new Random(System.currentTimeMillis());
    public static DecimalFormat decimalFormat = new DecimalFormat("#.0");

    public static double[] getUnchangePrice(double rangePrice,int randomNum){
        double[] moneyChange = new double[randomNum];
        for(int i=0;i<randomNum;i++){
            moneyChange[i] = rangePrice;
        }
        return moneyChange;
    }
    public static double[] getRandomPrice(double rangePrice,int randomNum){
        double[] moneyChange = new double[randomNum];
        for(int i=0;i<randomNum;i++){
            moneyChange[i] = getRandom(rangePrice);
        }
        return moneyChange;
    }
    public static double getRandom(double randomRange){
        return Double.parseDouble(decimalFormat.format(r.nextDouble()*randomRange));
    }
//    public static void main(String[] args){
//        double[] doubles = getRandomPrice(100,10);
//        for (double number:doubles){
//            System.out.println(number);
//        }
//    }
}
