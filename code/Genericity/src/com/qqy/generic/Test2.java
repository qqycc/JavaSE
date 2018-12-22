package com.qqy.generic;

/**
 * 泛型  x、y数据类型相同
 * Author: qqy
 */
public class Test2 <T>{
    private T x;
    private T y;

    public Test2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public static void main(String[] args) {
        //第二个<>JDK1.7之后（包含1.7）可以省略

        //Test2 Integer
        Test2<Integer> point=new Test2<>(10,20);
        Integer x=point.getX();
        Integer y=point.getY();
        System.out.println("("+x+","+y+")");

        //Test2 String
        Test2<String> point1=new Test2<>("东经20度","北纬50度");
        String strx=point1.getX();
        String stry=point1.getY();
        System.out.println("("+strx+","+stry+")");
    }
}
