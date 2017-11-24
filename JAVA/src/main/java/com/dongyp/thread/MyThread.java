package com.dongyp.thread;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/3
 */
public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("in MyThread run");
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
//            if(i == 50){
//                this.yield();
//            }
        }
    }
}
