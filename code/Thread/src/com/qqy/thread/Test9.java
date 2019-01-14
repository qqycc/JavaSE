package com.qqy.thread;

import java.time.LocalDateTime;

/**
 * 线程让步
 * Author: qqy
 */
public class Test9{
    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread6());
        Thread thread1=new Thread(new MyThread6());
        thread.start();
        thread1.start();
    }
}

class MyThread6 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"  "+i+"时间："+LocalDateTime.now());
        }
    }
}