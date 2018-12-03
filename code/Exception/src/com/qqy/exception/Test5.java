package com.qqy.exception;

/**
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        int a=50;
        //java默认不开启断言（-ea开启）
        assert a==55:"断言失败";
        System.out.println("断言成功");
    }
}
