package com.qqy.synchronization;

/**
 * 锁消除
 * Author: qqy
 */
public class Test11 {
    public static void main(String[] args) {
        //sb局部变量，每个线程都有自己的sb变量——不存在线程安全问题
        //JVM会把append()上的synchronized取消掉
        StringBuffer sb =new StringBuffer();
        sb.append("A").append("B").append("C");
    }
}
