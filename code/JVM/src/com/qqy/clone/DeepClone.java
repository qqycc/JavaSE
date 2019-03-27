package com.qqy.clone;

import java.io.*;

/**
 * 深拷贝
 * Author:qqy
 */
public class DeepClone {
    public static void main(String[] args) {
        Teacher2 teacher = new Teacher2("老师1");
        teacher.setAge(30);
        teacher.setSkill("唱歌");

        Student2 student1 = new Student2("学生1", 20, teacher);
        System.out.println(student1);
        System.out.println(teacher);

        Student2 student2 = student1.clone();
        student2.setName("学生2");
        student2.getTeacher().setSkill("跑步");
        student2.getTeacher().setAge(35);

        System.out.println(student2);
        System.out.println(teacher);
    }
}

class Teacher2 implements Serializable {
    private String name;
    private String skill;
    private int age;

    @Override
    public String toString() {
        return "Teacher1{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", age=" + age +
                '}';
    }

    public Teacher2(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student2 implements Serializable {
    private String name;
    private int age;
    private Teacher2 teacher;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public Student2 clone() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this);
            byte[] data=out.toByteArray();

            ByteArrayInputStream in=new ByteArrayInputStream(data);
            ObjectInputStream inputStream=new ObjectInputStream(in);
            return (Student2) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Student2(String name, int age, Teacher2 teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher2 getTeacher() {
        return teacher;
    }
}
