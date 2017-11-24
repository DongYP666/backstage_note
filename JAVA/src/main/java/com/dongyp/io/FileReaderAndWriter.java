package com.dongyp.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/21
 */
public class FileReaderAndWriter {
    public static void main(String[] args) {
        FileReader freader = null;
        FileWriter fwriter = null;

        try {
            freader = new FileReader("/Users/dongyp/Documents/test/testData.txt");
            // 文件不存在会创建一个
            fwriter = new FileWriter("/Users/dongyp/Documents/test/123.txt");

            char[] chars = new char[1024];
            int n = 0;
            while((n = freader.read(chars)) != -1){
                String str = new String(chars, 0 , n);
                System.out.println(str);
                fwriter.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                freader.close();
                fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
