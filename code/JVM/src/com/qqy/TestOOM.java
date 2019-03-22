package com.qqy;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 * JVM参数为:-Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * 命令行中 ：java -Xmx20m TestOOM
 * Author:qqy
 */
public class TestOOM {
    //定义一个类
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> data=new ArrayList<>();
        //一直创建对象
        while(true){
            data.add(new OOMObject());
        }
    }
}
