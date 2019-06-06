package com.qqy.calculation;

import java.util.Scanner;

/**
 * 尼科彻斯定理，即：任何一个整数 n 的立方都可以写成 n 个连续奇数之和。
 * 思路：
 *      第n个数字：令k=n-1,带入 m=(1+k)*k/2+1;
 *                将m带入，num=2*m-1;
 *                num就是第一个计数，再一次加n-1个奇数。
 * Author:qqy
 */
public class Nicochetes {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        while(in.hasNextInt()) {
            int k = in.nextInt() - 1;
            int m = (1 + k) * k / 2 + 1;
            int num = 2 * m - 1;
            for (int i = 0; i < k + 1; i++) {
                builder.append(String.valueOf(num));
                num += 2;
                if(i!=k){
                    builder.append("+");
                }
            }
            System.out.println(builder.toString());
            builder.delete(0,builder.capacity());
        }
    }
}
