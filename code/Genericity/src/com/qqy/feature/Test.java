package com.qqy.feature;

/**
 * 可变参数
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(add1());
        System.out.println(add1(1));
        System.out.println(add1(1,2));
        System.out.println(add1(1,2,3,4,5));
        System.out.println(add1(null));

    }

        //int...data => int[]
    public static int add1(int...data) {
        if(data==null){
            return 0;
        }
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
        }
        return sum;
    }
}
