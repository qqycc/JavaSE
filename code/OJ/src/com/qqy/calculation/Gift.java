package com.qqy.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 一个口袋总的容积是40
 * 有n个想要得到的物品，每个物品的体积分别是a1，a2....an。
 * 从中选出一些物体使得他们的总体积是40，有多少种不同的选择物品的方式。
 *
 * 简化问题：
 * 给出n个数，有几种相加 == 40的组合。
 *
 * 思路：
 * 1.满足条件的组合中数的个数1~n (type)
 * 2.遍历
 * Author:qqy
 */
public class Gift {
    static int[] weight;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            N = input.nextInt();
            weight = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                weight[i] = input.nextInt();
            }
            count(40, N);
            System.out.println(count);
        }
    }

    public static void count(int s, int n) {
        //如果正好装满
        if (s == 0) {
            ++count;
            return;
        }
        //是 s<0 或 还未满时n<1 则不能完成
        if (s < 0 || (s > 0 && n < 1)) {
            return;
        }
        count(s - weight[n], n - 1);
        count(s, n - 1);
    }
}
