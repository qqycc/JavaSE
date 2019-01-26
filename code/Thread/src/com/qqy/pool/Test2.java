package com.qqy.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时调度池
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 5; i++) {
            //延迟3秒
            scheduledExecutorService.schedule(myThread2, 3, TimeUnit.SECONDS);
            //延迟3秒，每隔2秒作为一个周期执行
            scheduledExecutorService.scheduleAtFixedRate(myThread2, 3,2, TimeUnit.SECONDS);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run()  {
        for (int i = 10; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
    }
}