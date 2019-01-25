package com.qqy.pool;

import java.util.concurrent.*;

/**
 * 线程池的基本使用
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread1 myThreadc = new MyThread1();
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 5; i++) {
            //execute()
            executorService.execute(myThread);
            //submit()
            Future future = executorService.submit(myThreadc);
            //get()--阻塞方法，等到当前线程跑完为止，其他线程才能运行
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class MyThread1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 10; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
        return Thread.currentThread().getName() + "结束";
    }
}