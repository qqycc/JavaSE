package com.qqy.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的基本使用
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread,"电话");
        Thread thread1=new Thread(myThread,"网站");
        Thread thread2=new Thread(myThread,"代理");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class MyThread implements Runnable{
    private int ticket=500;

    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
        for(int i=0;i<500;i++){
            try{
                //为程序上锁
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"剩余"+ticket--+"张票");
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
