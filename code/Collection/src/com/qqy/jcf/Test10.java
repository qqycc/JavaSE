package com.qqy.jcf;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 遍历中删除元素
 * Author:qqy
 */
public class Test10 {
    public static void main(String[] args) {
        Set<Person1> people = new TreeSet<>();
        people.add(new Person1("Jack", 22));
        people.add(new Person1("Alice", 18));

        Iterator<Person1> iterator = people.iterator();
        while (iterator.hasNext()) {
            //需要先next，再remove
            //满足条件 -> 删除
            Person1 p = iterator.next();
            if (p.getName().equals("Jack")) {
                System.out.println(p);
                //一个hasNext()后不能iterator.next()两次,两者成对出现，否则游标不变
//                System.out.println(iterator.next());
                iterator.remove();
            }
        }

        System.out.println(people);
    }
}

