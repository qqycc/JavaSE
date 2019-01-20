package com.qqy.threadlocal;

/**
 * ThreadLocal的简单使用
 * staticCommValue主线程修改完子线程再修改，——staticCommValue是共享的
 * threadLocal在子线程中修改的值在主线程看不到
 * Author: qqy
 */
public class Test {
    //多线程共享
    private static String staticCommValue;

    //多线程独立
    //实现方式一
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    //实现方式二：withInitial()静态方法，JDK8提供，可以实例化一个对象，初始化值(供给性函数)Hello
    private static ThreadLocal<String> threadLocal1=ThreadLocal.withInitial(()->"Hello");

    //实现方式三：匿名内部类覆写initialValue()
    private static ThreadLocal<String> threadLocal2=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Hello";
        }
    };

    //main()是在Thread-main线程执行
    public static void main(String[] args) {
        //主线程中修改staticCommValue
        staticCommValue="main线程修改的staticCommValue";
        //在主线程中修改threadLocal
        threadLocal.set("这是main线程修改的threadLocal");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程中修改staticCommValue
                staticCommValue="子线程修改的staticCommValue";
                //在子线程中修改threadLocal
                threadLocal.set("这是子线程修改的threadLocal");
                System.out.println("子线程"+threadLocal.get());
            }
        },"子线程");

        thread.start();
        //等待子线程运行完后，主线程继续
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(staticCommValue);
        System.out.println(threadLocal.get());
    }
}
