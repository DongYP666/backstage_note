package com.dongyp.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/21
 */
public class InputStreamExample {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("/Users/dongyp/Documents/test/testData.txt");
            byte[] bytes = new byte[1024];
            int n = 0;
            // n 用来存储 bytes 的长度
            while((n=fin.read(bytes))!= -1){
                String str = new String(bytes,0,n);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
