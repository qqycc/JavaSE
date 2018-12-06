package com.qqy.exception;

/**
 * Author: qqy
 */
public class Throwable {
    public static void code(){
        System.out.println("1.开始");
        try{
            System.out.println("2.计算结果"+(10/2));
            System.exit(0);
        }catch (ArithmeticException e){
            System.out.println("异常已处理");
        }finally{
            System.out.println("Finally");
        }
        System.out.println("3.结束");
    }

    public static int code1(int a,int b){
        int c=a+b;   //25
        try{
            c=c+10;  //35
            return c;
        }finally {
            c=c+20;  //55
        }
    }

    public static void main(String[] args) {
        System.out.println(code1(10,15));  //35
        code();  //1.开始
                 // 2.计算结果5
    }
}


