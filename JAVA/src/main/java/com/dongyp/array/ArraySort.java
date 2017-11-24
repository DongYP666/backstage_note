package com.dongyp.array;

/**
 * Created by dongyp on 2017/6/20.
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,6,8,9,7,4,1,0};

        //冒泡排序
        /*
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        */

        //快速选择排序
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }

        //数组遍历
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "\t");
        }
    }
}
