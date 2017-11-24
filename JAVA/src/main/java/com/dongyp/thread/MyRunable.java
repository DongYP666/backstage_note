package com.dongyp.thread;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/3
 */
public class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
