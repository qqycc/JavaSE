package com.qqy.synchronization;

/**
 * 同步方法
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread2 mt=new MyThread2();
        Thread thread=new Thread(mt,"电话");
        Thread thread1=new Thread(mt,"网站");
        Thread thread2=new Thread(mt,"代购");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

//实现Runnable接口——多个窗口共同售票
class MyThread2 implements Runnable{
    //票数是共享资源
    private int ticket=100;

    @Override
    public void run() {
       for(int i=0;i<100;i++){
           this.sale(ticket);
       }
    }

    //同步方法
    public synchronized void sale(int ticket){
        if(ticket>0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  剩余"+this.ticket--+"张票");
        }
    }
}