package com.qqy.String;

import java.util.Scanner;

/**
 * 判断N是否为守形数
 * 守形数:它的平方的低位部分等于它本身。
 * 比如25的平方是625，低位部分是25，因此25是一个守形数。
 * Author:qqy
 */
public class ConservativeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int num=in.nextInt();
            judge(num);
        }
    }

    public static void judge(int num){
        String str=String.valueOf(num*num);
        if(str.endsWith(String.valueOf(num))){
            System.out.println("Yes!");
        }else{
            System.out.println("No!");
        }
    }
}
