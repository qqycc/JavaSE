package com.qqy.synchronization;

/**
 * 死锁
 * Author: qqy
 */
public class Test12 {
    private static Pen pen = new Pen();
    private static Book book = new Book();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book) {
                    System.out.println(Thread.currentThread().getName() + "书正在用");
                    synchronized (pen) {
                        System.out.println(Thread.currentThread().getName() + "把笔给我");
                    }
                }
            }
        }, "Book");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen) {
                    System.out.println(Thread.currentThread().getName() + "笔正在用");
                    synchronized (book) {
                        System.out.println(Thread.currentThread().getName() + "把书给我");
                    }
                }
            }
        }, "Pen");

        thread1.start();
        thread2.start();
    }
}

class Pen{
    private String name="笔";

    public String getName() {
        return name;
    }
}

class Book{
    private String name="书";

    public String getName() {
        return name;
    }
}