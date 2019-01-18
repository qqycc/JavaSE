package com.qqy.synchronization;

/**
 * synchronized对象锁
 * 只有一个对象，成功锁住
 * Author: qqy
 */

public class Test5 {
    public static void main(String[] args) {
        Sync1 sync=new Sync1();
        MyThread4 mt=new MyThread4(sync);
        for(int i=0;i<3;i++){
            new Thread(mt,"线程"+i+"  ").start();
        }
    }
}

class MyThread4 implements Runnable{
    //只有一个对象
    private Sync1 sync;

    public MyThread4(Sync1 sync){
        this.sync=sync;
    }

    @Override
    public void run() {
        this.sync.test();
    }
}

class Sync1{
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