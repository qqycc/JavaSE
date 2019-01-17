package com.qqy.synchronization;

/**
 * synchronized对象锁
 * 仍是同时开始，同时结束，并没有锁住
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        MyThread3 mt=new MyThread3();
        for(int i=0;i<3;i++){
            //不是同一个线程，没有锁住
            new Thread(mt,"线程"+i+"  ").start();
        }
    }
}

class MyThread3 implements Runnable{

    @Override
    public void run() {
        Sync sync=new Sync();
        //多个对象
        //sync1，线程0
        //sync2，线程1
        //sync3，线程2
        sync.test();
    }
}

class Sync{
    //锁住的是当前对象this
    public synchronized void test(){
        System.out.println(Thread.currentThread().getName()+"test开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"test结束");
    }
}