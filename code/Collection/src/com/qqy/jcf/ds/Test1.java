package com.qqy.jcf.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue队列的基本使用
 * Author:qqy
 */
public class Test1 {
    public static void main(String[] args) {
        //LinkedList 左边类型 Queue
        Queue<String> queue = new LinkedList<>();
        System.out.println("队列的元素是否为空：" + queue.isEmpty());
        //入队列 add
        queue.add("Java");
        queue.add("C++");

        System.out.println("队列的元素是否为空：" + queue.isEmpty());
        queue.add("PHP");
        System.out.println("队列的元素数量：" + queue.size());

        //查看队头
        System.out.println("队头元素时：PHP " + "PHP".equals(queue.peek()));//false

        //出队列 poll
        System.out.println(queue.poll());//Java
        System.out.println(queue.poll());//C++
        System.out.println(queue.poll());//PHP
        System.out.println(queue.poll());//null
    }
}
