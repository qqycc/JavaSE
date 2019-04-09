package com.qqy;

/**
 * 浅拷贝
 * 引用数据类型原对象和克隆对象共享
 * Author:qqy
 */
public class TestClone {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.setName("Jack");
        teacher.setSkill("弹琴");

        System.out.println("Teacher的信息");
        System.out.println(teacher);

        Student student=new Student();
        student.setAge(18);
        student.setName("lila");
        student.setTeacher(teacher);

        Student student1=student.clone();
        if(student1!=null){
            System.out.println("Clone的student1");
            System.out.println(student1);
        }

        student1.getTeacher().setSkill("跑步");
        System.out.println("Clonede student1修改Teacher之后");
        System.out.println(student1);

        System.out.println("Teacher的信息");
        System.out.println(teacher);
    }
}

class Teacher{
    private String name;
    private String skill;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}

//如果一个类要调用Clone()，要实现Cloneable接口
class Student implements Cloneable{
    private String name;
    private Integer age;
    private Teacher teacher;
    public Student clone(){
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
