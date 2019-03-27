package com.qqy.clone;

/**
 * 浅拷贝
 * 引用数据类型原对象和克隆对象共享
 * Author:qqy
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Teacher1 teacher=new Teacher1("老师1");
        teacher.setAge(30);
        teacher.setSkill("唱歌");

        Student1 student1=new Student1("学生1",20,teacher);
        System.out.println(student1);
        System.out.println(teacher);

        Student1 student2= (Student1) student1.clone();
        student2.setName("学生2");
        student2.getTeacher().setSkill("跑步");
        student2.getTeacher().setAge(35);

        System.out.println(student2);
        System.out.println(teacher);
    }
}

class Teacher1{
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

    public Teacher1(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student1 implements Cloneable{
    private String name;
    private int age;
    private Teacher1 teacher;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Student1(String name, int age, Teacher1 teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher1 getTeacher() {
        return teacher;
    }
}