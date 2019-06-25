package com.qqy.calculation;

import java.util.Scanner;

/**
 * 角色的初始能力值为a，依次遇见n个怪物，每个怪物的防御力为b1，，b2，b3..bn。
 * 如果防御力bi<=当前能力值c，那么就能使得自己的能力值增加bi；
 * 如果bi>c，能力值只能增加bi与c的最大公约数。
 * 在一系列的锻炼后，最终能力值为多少？
 * 输入描述：
 * 对于每组数据，第一行是两个整数n（n：1~100000）表示怪物的数量和a表示初始能力值.
 * 第二行n个整数，b1，b2...bn（bi:1~n）表示每个怪物的防御力
 * 输出描述：
 * 对于每组数据，输出一行。每行仅包含一个整数，表示最终能力值
 *
 * 思路:
 *  1.写一个求最大公约数的方法
 *      辗转相除法
 *  2.根据条件判断
 * Author:qqy
 */
public class UpgradeGame {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            String b=in.nextLine();
            String[] arr=str.split(" ");
            int len=Integer.parseInt(arr[0]);
            int init=Integer.parseInt(arr[1]);
            String[] power=b.split(" ");
            int cur=init;
            for(int i=0;i<len;i++){
                int battle=Integer.parseInt(power[i]);
                cur+=battle>cur?GCD(battle,cur):battle;
            }
            System.out.println(cur);
        }
    }

    public static int GCD(int a,int b){
        int remainder=1;
        while(remainder!=0) {
            remainder = a % b;
            a=b;
            b=remainder;
        }
        return a;
    }
}
