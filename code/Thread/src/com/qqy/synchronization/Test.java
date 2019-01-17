package com.qqy.synchronization;

/**
 * 引出同步
 * 多个窗口共同售票，票数出现负数——不同步操作
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        Thread thread=new Thread(mt,"电话");
        Thread thread1=new Thread(mt,"网站");
        Thread thread2=new Thread(mt,"代购");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

//实现Runnable接口——多个窗口共同售票
class MyThread implements Runnable{
    private int ticket=10;

    @Override
    public void run() {
        while(ticket>0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"剩余"+this.ticket--+"票");
        }
    }
}
