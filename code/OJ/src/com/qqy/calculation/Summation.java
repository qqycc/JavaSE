package com.qqy.calculation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入两个整数n和m，从数列1，2，3.....n中随意取几个数，使其和等于m，要求将其中所有的可能组合列出。
 * Author:qqy
 */
public class Summation {
    // res 用于保存最终结果
    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            dfs(1, m, n);
            // 打印结果集合
            for (ArrayList<Integer> l : res) {
                int i = 0;
                for (; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    public static void dfs(int index, int count, int n) {
        if (count == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = index; i <= count && i <= n; i++) {
                list.add(i);
                dfs(i + 1, count - i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
