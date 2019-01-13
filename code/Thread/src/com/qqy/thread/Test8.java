package com.qqy.thread;

import java.time.LocalDateTime;

/**
 * 线程睡眠
 * Author: qqy
 */
public class Test8 {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread5());
        Thread thread1=new Thread(new MyThread5());
        thread.start();
        thread1.start();
    }
}

class MyThread5 implements Runnable{
    @Override
    public void run() {
       for(int i=0;i<10;i++){
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"  "+i+"时间："+LocalDateTime.now());
       }
    }
}

