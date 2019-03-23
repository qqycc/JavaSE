package com.qqy;

/**
 *  引用计数法
 *  JVM参数 :-XX:+PrintGC  打印GC使用时的状态，不打印无法看出是否回收
 * Author:qqy
 */
public class TestGc {
    public Object instance=null;
    //编译器在编译代码的时候就将值计算好了，效率更高
    private static final int _2MB=1024*1024*2;
    private byte[] data=new byte[_2MB];

    public static void main(String[] args) {
        TestGc test1=new TestGc();
        TestGc test2=new TestGc();
        test1.instance=test2;
        test2.instance=test1;
        test1=null;
        test2=null;

        //执行垃圾回收
        System.gc();
    }
}

//垃圾回收器的日志信息
//7M回收后 0.8M    0.8M回收后0.6M
//如果GC触发后没有回收，前后两个数字应该是相等的或者差距不大
//[GC (System.gc())  7424K->704K(125952K), 0.0099487 secs]
//[Full GC (System.gc())  704K->638K(125952K), 0.0345349 secs]