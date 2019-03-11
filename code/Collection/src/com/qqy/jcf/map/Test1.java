package com.qqy.jcf.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HashMap
 * Author:qqy
 */
public class Test1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "java");
        map.put("2", "C++");
        map.put("3", "Python");

        //遍历map的三种方法
        // keySet -> get  ;
        // 只获取value：values ;
        // entrySet(foreach)

        System.out.println("通过Entry遍历map");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //foreach、iterator ,Set没有下标，不能使用for循环
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //优化
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
