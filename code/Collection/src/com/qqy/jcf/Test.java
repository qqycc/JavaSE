package com.qqy.jcf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList基本使用
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //向上转型  实例化一个ArrayList对象 ，List类型
        List<String> list=new ArrayList<>();
        list.add("good");
        list.add("hello");
        //重复元素
        list.add("good");
        System.out.println(list);  //[good, hello, good]
        System.out.println(list.indexOf("good"));  //0  第一个good的下标
        System.out.println(list.indexOf("better"));  //-1  不存在
        System.out.println(list.contains("good"));  //true
        System.out.println(list.remove("good")); //true  删除第一个good

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");  //hello good
        }

        list.set(1,"bonjour");
        System.out.println(list);  //[hello, bonjour]

        //迭代器接口
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(",");  //hello,bonjour,
        }

        list.clear();
        System.out.println(list.size());  //0
    }
}


