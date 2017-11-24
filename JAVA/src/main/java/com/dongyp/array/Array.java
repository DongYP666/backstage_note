package com.dongyp.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dongyp on 2017/6/19.
 *
 * 数组练习
 */

public class Array {
    /*
     * 数组一旦初始化，其长度不可变
     */
    public static void main(String[] args) {
        // 声明数组
        int[] array;
        // 为数组开辟空间
        array = new int[3];
        // 为数组赋值
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        // 1.数组静态初始化
        int[] array1 = new int[]{1,2,3};
        int[] array2 = {1,2,3};

        // 2.数组动态初始化
        int[] array3 = new int[3];
        array3[0] = 1;
        array3[1] = 2;
        array3[2] = 3;

        /* ----------------------- 二维数组 ----------------------- */

        // 1.二维数组静态初始化
        int[][] score1 = new int[][]{{1,2,3},{4,5,6},{7}};

        // 2.二维数组动态初始化
        int[][] score2 = new int[3][4]; //等价于 int[] score2[] = new int[3][4]
        int[][] score3 = new int[3][];
        score3[0] = new int[3];
        score3[1] = new int[4];
        score3[2] = new int[5];

        /* ----------------------- 关于list转array ----------------------- */

        Array thisClass = new Array();

        List<String> list = Arrays.asList("111","222","333");
        System.out.println(list);
        System.out.println(list.toString());
        thisClass.fuc(list.toArray(new String[list.size()]));

        String[] strArray = {"1111","2222","3333"};
        System.out.println(strArray);
        System.out.println(strArray.toString());
        thisClass.fuc(strArray);
    }

    public void fuc(String... userCode){
        System.out.println(userCode);
        System.out.println(userCode.toString());
        for (String str : userCode){
            System.out.println(str);
        }
    }
}
