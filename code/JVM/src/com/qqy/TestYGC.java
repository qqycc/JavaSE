package com.qqy;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC(使用Serial+Serial Old收集器组合)
 * -Xms20M -Xmx20M -Xmn10M(设置新生代大小)
 * -XX:SurvivorRatio=8(Eden:Survivor = 8 : 1)
 * Author:qqy
 */
public class TestYGC {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        //1:1的部分放不下2MB，放入老年代，最大20M，老年代能放下
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}
