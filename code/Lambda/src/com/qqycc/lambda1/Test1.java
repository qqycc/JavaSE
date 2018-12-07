package com.qqycc.lambda1;

/**
 * 标准的Lambda
 * Author: qqy
 */
@FunctionalInterface
interface IAdd{
    int add(int x,int y);
}

public class Test1 {
    public static void main(String[] args) {
        IAdd add=new IAdd(){
            @Override
            public int add(int x, int y) {
                int result=x+y;
                result+=5;
                return result;
            }
        };

        IAdd add1= (x, y) -> {
            int result=x+y;
            result+=10;
            return result;
        };

        System.out.println(add.add(10,20));   //35
        System.out.println(add1.add(10,20));  //40
    }
}
