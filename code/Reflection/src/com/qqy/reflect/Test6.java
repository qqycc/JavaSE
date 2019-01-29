package com.qqy.reflect;

import java.lang.reflect.Field;

/**
 * 反射调用类中属性
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) {
        try {
            Class classes = Class.forName("com.qqy.reflect.Student");
            //获取属性 public
            System.out.println("输出Student类的所有公开属性：");
            for (Field f : classes.getFields()) {
                System.out.println(f);
            }

            System.out.println("输出Student类的指定公开属性：");
            Field major1 = classes.getField("name");
                System.out.println(major1);

            System.out.println("输出Student类的本类声明的属性");
            for (Field f : classes.getDeclaredFields()) {
                System.out.println(f);
            }

            System.out.println("获取指定属性");
            Field major = classes.getDeclaredField("major");
            System.out.println(major);


            //Student一个对象
            Student student = (Student) classes.newInstance();
            System.out.println("实例化后的信息：" + student);

            //major是私有属性，本不能更改值，但是可以强制访问
            //在一次JVM进程中有效，当JVM关闭后，即使再次开启，仍无效
            major.setAccessible(true);
            major.set(student, "信息与计算科学");

            System.out.println("通过major Field赋值之后：" + student);
            Object value = major.get(student);
            System.out.println("通过major Field获取值：" + value);

            //在一次JVM进程中，setAccessible一直有效
            major.set(student, "网络工程");

            System.out.println("通过major Field赋值之后：" + student);
            Object value1 = major.get(student);
            System.out.println("通过major Field获取值：" + value1);


            //获取Field类型
            System.out.println(major.getType());

        } catch (ClassNotFoundException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Student extends Person {

    private String teacher;

    private String major;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", major='" + major + '\'' +
                "} " + super.toString();
    }
}
