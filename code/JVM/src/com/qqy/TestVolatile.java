package com.qqy;

/**
 * 有重复的值，说明线程不可见
 * Author:qqy
 */
public class TestVolatile {
    private static volatile int num=0;

    //num内存可见
    //但是num++不可见，因为不是原子性操作，分为两步 num=num+1,做运算再赋值
    public static void add(){
        num++;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                add();
                System.out.println(Thread.currentThread().getName()+" "+num);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("Thread_Volatile_"+i);
            thread.start();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
