package com.dongyp.thread;

import java.util.concurrent.Callable;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/3
 */
public class MyCallabe implements Callable<Integer> {

    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
