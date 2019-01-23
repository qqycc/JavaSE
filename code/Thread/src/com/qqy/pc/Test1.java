package com.qqy.pc;

/**
 * wait()
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        Thread thread=new Thread(mt);
        thread.start();

//        //object.wait();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();

    }
}

class MyThread implements Runnable{
    private Object object=new Object();

    @Override
    public void run() {
        synchronized (object){
            System.out.println("wait()开始");
            try {
                //等1s后，结束
                object.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait()结束");
        }
    }
}