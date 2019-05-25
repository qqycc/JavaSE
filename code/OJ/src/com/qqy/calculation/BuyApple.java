package com.qqy.calculation;


/**
 * 90%
 * 商店只提供6个苹果每袋和8个苹果每袋的包装（包装不可拆分）。
 * 若只想购买恰好n个苹果，想购买尽量少的袋数方便携带，输出最少购买的袋数。
 * 如果不能购买恰好n个苹果，将不会购买，输出-1。
 * 思路
 *      1.如果是8的倍数，全部买8个装
 *      2.每次减去6个苹果，看剩余的能否为8的n倍（利用count记录减去6个苹果的次数）
 *          是：返回n+count
 *          不是：继续减，直至减到0
 *      3.若a<0,返回-1
 * Author:qqy
 */
public class BuyApple {
    public static void main(String[] args) {
       buy(20);
    }
    public static void buy(int a){
        int count=0;
        while(a>=0){
            if(a%8==0){
                System.out.println(a/8+count);
                return;
            }
            a-=6;
            count++;
        }
        System.out.println(-1);
    }

}
