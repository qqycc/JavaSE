package com.qqy.jcf;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * foreach遍历集合
 * Author:qqy
 */
public class Test9 {
    public static void main(String[] args) {
        Set<Person1> people = new TreeSet<>();
        people.add(new Person1("Jack", 22));
        people.add(new Person1("Alice", 18));

        //foreach方式遍历集合（List,Set ...）
        //for、while、foreach方式遍历依赖于迭代器
        //若在foreach中修改集合，会出现ConcurrentModificationException（并发修改异常），线程不安全
        for (Person1 person : people) {
            //people.add(new Person1("Tom", 23));
            System.out.println(person);
        }

        //遍历集合：Iterator 可以 add remove
        Iterator<Person1> iterator = people.iterator();
        while (iterator.hasNext()) {
//            people.add(new Person1("Tom", 23));
            //需要先next，再remove
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(people);
    }
}

 class Person1 implements Comparable<Person1>{

    private String name;

     private Integer age;

     public Integer getAge() {
         return age;
     }

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    //1. equals 和 hashCode 方法覆写一定要一起使用
//    //2. equals参与判断的属性都要参与hashCode的计算
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person1 person = (Person1) o;
//
//        if (!name.equals(person.name)) return false;
//        return age.equals(person.age);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + age.hashCode();
//        return result;
//    }

     @Override
     public int compareTo(Person1 o) {
         return this.age - o.getAge();
     }
 }
