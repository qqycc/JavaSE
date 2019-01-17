package com.qqy.synchronization;

/**
 * 同步代码块
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread1 mt=new MyThread1();
        Thread thread=new Thread(mt,"电话");
        Thread thread1=new Thread(mt,"网站");
        Thread thread2=new Thread(mt,"代购");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

//实现Runnable接口——多个窗口共同售票
class MyThread1 implements Runnable{
    //票数是共享资源
    private int ticket=100;

    @Override
    public void run() {
        //同一时刻可以由多个线程进入方法，但只能有一个线程进入同步代码块
        for(int i=0;i<100;i++){
            //同步代码块
            synchronized(this){
                // ---------------------------------
                if(ticket>0){
                    try {
                        //模拟网络延迟
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"  剩余"+this.ticket--+"张票");
                }
                // ---------------------------------
           }
        }
    }
}
