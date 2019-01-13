package com.qqy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable<V>实现多线程
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        Callable<String> callable=new Mycallable();
        //FutureTask构造方法可以传Callable
        FutureTask<String> futureTask=new FutureTask(callable);
        Thread thread=new Thread(futureTask);
        Thread thread1=new Thread(futureTask);
        thread.start();
        thread1.start();

        try {
            String result=futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}

class Mycallable implements Callable<String>{
    private int ticket=10;

    @Override
    public String call() throws Exception {
        while(ticket>0){
            System.out.println(Thread.currentThread()+"剩余"+this.ticket--+"票");
        }
        //有返回值
        return "已售罄";
    }
}
