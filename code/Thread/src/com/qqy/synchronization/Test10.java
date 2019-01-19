package com.qqy.synchronization;

/**
 * 锁粗化
 * Author: qqy
 */
public class Test10 {
    //sb是类的属性，多个线程共享——存在线程安全问题
    private static StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {
        //每次调用append()都要进行加锁、解锁，调用三次（进三次同步方法）
        //但是，JVM会进行优化——在sb.append("A")时加锁，在sb.append("C")执行完后再解锁
        sb.append("A");
        sb.append("B");
        sb.append("C");
    }
}
