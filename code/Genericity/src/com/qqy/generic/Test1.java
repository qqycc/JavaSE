package com.qqy.generic;

/**
 * 泛型  x、y数据类型不同
 * Author: qqy
 */
public class Test1<T,S> {
    private T x;
    private S y;

    public Test1(T x, S y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public S getY() {
        return y;
    }

    public String toString(){
        return "Test1{\""+
                "x="+x+
                " y="+y+
                "\"}";
    }

    public static void main(String[] args) {
        Test1<Integer,String> point= new Test1<>(20, "你好");
        Integer x=point.getX();
        String y=point.getY();
        System.out.println("("+x+","+y+")");
    }
}
