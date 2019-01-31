package com.qqy.reflect;

/**
 * 给属性赋值
 * 旧方法
 * Author:qqy
 */
public class Test7 {
    public static void main(String[] args) {
        Person per=new Person();
        per.setAge(18);
        per.setName("张三");
        System.out.println(per);
    }
}

class Person1{
    private String name;
    private String job;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
