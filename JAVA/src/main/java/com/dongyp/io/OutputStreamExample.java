package com.dongyp.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/21
 */
public class OutputStreamExample {
    public static void main(String[] args) {
        FileOutputStream fout = null;
        try {
            // 若是文件不存在会创建文件，且会覆盖原文件中的内容
            // 传递一个true参数，代表不覆盖已有文件，并在文件末尾处进行续写 例:new FileOutputStream(path,true)
            fout = new FileOutputStream("/Users/dongyp/Documents/test/111.txt");
            String str = "难道就是这样\n";
            byte[] bytes = str.getBytes();
            fout.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
