package com.qqycc.lambda1;

/**
 * 有return的Lambda
 * Author: qqy
 */
@FunctionalInterface
interface IAddto{
    int add(int x,int y);
}

public class Test {
    public static void main(String[] args) {
        IAddto add=new IAddto() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };

        //函数式编程
        IAddto add1=(x, y)-> x+y+10;

        System.out.println(add.add(10,20));  //30
        System.out.println(add1.add(10,20)); //40
    }
}
