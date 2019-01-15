package com.qqy.thread;

/**
 * 设置标记位停止线程、stop方法强制停止线程
 * Author: qqy
 */
public class Test11 {
    public static void main(String[] args) {
        MyThread8 mt=new MyThread8();
        Thread thread=new Thread(mt,"A");
        thread.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置标记位停止线程
        mt.setFlag(false);
        //stop方法强制停止线程
//        thread.stop();
    }
}

class MyThread8 implements Runnable{
    private boolean flag=true;

    @Override
    public void run() {
        int i=1;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
    //提供更改标记位的方法
    public void setFlag(boolean flag){
        this.flag=flag;
    }
}