package com.qqy.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 * Author: qqy
 */
public class Test9 {
    public static void main(String[] args) {
        LockRunnable runnable=new LockRunnable();
        Thread threadA=new Thread(runnable,"电话");
        Thread threadB=new Thread(runnable,"网站");
        Thread threadC=new Thread(runnable,"代理");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class LockRunnable implements Runnable{
    private Lock lock=new ReentrantLock();
    private int ticket=500;

    @Override
    public void run() {
        for(int i=0;i<500;i++){
            //显式上锁,一般置于try之前，避免发生未知的异常
            lock.lock();
            try {
                Thread.sleep(20);
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"剩余"+this.ticket--+"票");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //无论是否出现异常，都可以解锁
                lock.unlock();
            }
        }
    }
}