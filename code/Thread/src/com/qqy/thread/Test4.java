package com.qqy.thread;

/**
 * 利用多线程模拟卖票(程序共享)——Thread
 * Author: qqy
 */
public class Test4{
    public static void main(String[] args) {
        Thread1 thread= new Thread1();
        Thread1 thread1= new Thread1();
        thread.setName("Thread-A");
        thread1.setName("Thread-B");

        thread.start();
        thread1.start();
    }
}

class Thread1 extends Thread{
    private static int ticket=10;

    @Override
    public void run() {
        while(ticket>0){
            System.out.println(this.getName()+"剩余:"+ticket--+"张票");
        }
    }
}
