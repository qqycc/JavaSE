package com.qqy.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 思路：
 *  1.递归
 *      最后一次爬要么是1阶，要么是2阶
 *          1. 1阶 返回1+前n-1阶爬的次数
 *          2. 2阶 返回2+前n-2阶爬的次数
 *  2.非递归
 *      从第一次爬楼梯开始计算，将每次的结果存储到ArrayList当中
 * Author:qqy
 */
public class ClimbStairs {
    //递归
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int climbStairs1(int n) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int i=2;
        for(;i<n;i++){
            list.add(i,list.get(i-2)+list.get(i-1));
        }
        return list.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(9));
        System.out.println(climbStairs1(9));
    }
}
