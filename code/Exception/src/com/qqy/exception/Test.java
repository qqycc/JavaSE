package com.qqy.exception;

/**
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("1.开始");
        try{
            System.out.println("2.计算结果"+(10/0));
        }catch (ArithmeticException e){       //e:异常的实例化对象，由JVM实例化
            //1.打印异常信息——System.err(无法确定打印的顺序)
            e.printStackTrace();
            //2.获取异常信息并打印，可以确定打印顺序
            String msg=e.getMessage();
            System.out.println(msg);
            System.out.println("异常已处理");
        }finally{
            System.out.println("Finally");
        }
        System.out.println("3.结束");
    }
}
