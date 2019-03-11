package com.qqy.jcf.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map
 * Author:qqy
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "java");
        map.put("2", "C++");
        map.put("3", "Python");

        System.out.println(map.containsKey("1"));//true
        System.out.println(map.containsKey("4"));//false
        System.out.println(map.get("1"));//java

        //1.HashMap key value 是可以为null
        map.put(null, "key is null");
        map.put("4", null);
        map.put("4", "PHP");
        System.out.println(map.size());//5  ∵key相等，对应的value会被覆盖掉
        System.out.println(map.get("4"));//PHP
        System.out.println(map.get("6"));//null  -> key不存在，get获得null

        //获取map中的所有key
        System.out.println("获取所有的key:");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("输出key=value:");
        for (String key : keys) {
            System.out.println(key + "=" + map.get(key));
        }

        System.out.println("输出所有的value:");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
    }
}
