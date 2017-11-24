package com.dongyp.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/20
 */
public class FileExample {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath1 = "/Users/dongyp/Documents/test/111.txt";
        File file1 = new File(filePath1);
        if(file1.exists()){
            System.out.println("文件" + filePath1 + "存在");
        }else{
            try {
                System.out.println("创建文件" + filePath1);
                // 创建文件, 若目录不存在报错 No such file or directory; 若目录存在且文件不存在就创建文件,文件存在不会被覆盖;
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String filePath2 = "/Users/dongyp/Documents/test";
        File file2 = new File(filePath2);
        if(file2.isDirectory()){
            System.out.println("文件" + filePath2 + "是一个目录");
            System.out.println("打印" + filePath2 + "下所有文件");
            File[] files = file2.listFiles();
            for (int i = 0; i < files.length; i++){
                System.out.println("文件" + (i+1) + ":" + files[i].getName());
            }
        }else {
            System.out.println("创建目录" + filePath2);
            // 创建目录, 若目录不存在则创建目录
            file2.mkdir();
        }
    }
}
