package com.qqy.calculation;

import java.util.Scanner;

/**
 * 求一个正整数n！末尾有多少个0
 * Author:qqy
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int count=0;
        for(int i=1;i<=n;i++) {
            int cur=i;
            while (cur % 5 == 0) {
                cur /= 5;
                count ++;
            }
        }
        System.out.println(count);
    }
}
