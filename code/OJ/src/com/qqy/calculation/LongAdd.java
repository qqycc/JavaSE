package com.qqy.calculation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 两个超长整数相加
 * Author:qqy
 */
public class LongAdd {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String a=in.next();
            String b=in.next();
            BigInteger num1=new BigInteger(a);
            BigInteger num2=new BigInteger(b);
            String sum=String.valueOf(num1.add(num2));
            System.out.println(sum);
        }
    }
}
