package com.qqy.calculation;

import java.util.Scanner;

/**
 * 对于给定的正整数n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
 * Author:qqy
 */
public class Sum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int num=in.nextInt();
            sum(num);
            System.out.print(" ");
            sum(num*num);
        }
    }

    public static void sum(int num){
        int sum=0;
        int temp;
        while(num>0){
            temp=num%10;
            sum+=temp;
            num/=10;
        }
        System.out.print(sum);
    }
}
