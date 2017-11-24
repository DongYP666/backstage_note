package com.dongyp.thread;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/3
 */
public class ThreadTest {
    public static void main(String[] args){
        System.out.println("主线程开始");

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setPriority(Thread.MIN_PRIORITY);
        myThread2.setPriority(Thread.MAX_PRIORITY);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程结束");
    }
}
