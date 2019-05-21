package com.qqy.calculation;

import java.util.Scanner;

/**
 * 三个空汽水瓶可以换一瓶汽水。如果有n个空汽水瓶，最多可以换多少瓶汽水喝?
 * 思路：
 *      设count=0,先加上n/3，再将n/3+n%3,继续进行运算，直到没有瓶子。
 *      终止条件：
 *          有两个瓶子的时候，直接加1，结束。
 *          有一个瓶子和没有瓶子的时候，结束。
 * Author:qqy
 */
public class ExchangeBottles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();

            int count=0;
            while(true){
                count+=a/3;
                a=a/3+a%3;
                if(a==0||a==1){
                    break;
                }
                if(a==2){
                    count++;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
