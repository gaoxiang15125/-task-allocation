package com.crawler.seller.taobao.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-05-05 16:19
 * @email: 630268696@qq.com
 **/
public class GzipTools {

    public static String uncompressString(byte[] bytes){

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream gunzip = null;
        try {
            gunzip = new GZIPInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[256];
        int n;
        try{
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return out.toString();
    }

}
