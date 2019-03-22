package com.qqy;

/**
 * 栈溢出
 * Author:qqy
 */
public class TestStack {
    private int depth = 1;

    public void test() {
        depth++;
        this.test();
    }

    public static void main(String[] args) {
        TestStack test = new TestStack();
        try {
            test.test();
            //栈溢出异常最终继承了Throwable，所以可以捕获Throwable
            //不是受查异常
            //继承runtime异常和error的子类，成为运行时异常
        } catch (Throwable e) {
            System.out.println("Stack Length: " + test.depth);
            throw e;
        }
    }
}
