package com.qqy.calculation;

import java.util.Scanner;

/**
 * Fibonacci数列是这样定义的：
 * F[O]=0
 * F[1]=1
 * for each i≥ 2：F[i]=F[i-1]+F[i-2]
 * <p>
 * 给一个N，让其变为一个Fibonacc数，每一步你可以把当前数字X变为X-1或者X+1，
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * N(1≤N≤1,000,000)，约等于F[30]
 * <p>
 * 思路：
 * 1.求斐波那契数
 * 2.采用二分法和所给数字比较,从F[15]开始比较
 * Author:qqy
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int left = 0, right = 30;
            int mid = 0;

            while (left < right) {
                mid = (right - left) / 2 + left;
                if (fibonacci(mid) > num) {
                    right = mid - 1;
                } else if (fibonacci(mid) < num) {
                    left = mid + 1;
                } else {
                    break;
                }
            }
            int res = 0;
            if (fibonacci(mid) == num) {
                res=0;
            } else if (fibonacci(left) > num) {
                int oneF = fibonacci(left);
                int twoF = fibonacci(left - 1);
                res = (num - twoF) > (oneF - num) ? (oneF - num) : (num - twoF);
            } else {
                int oneF = fibonacci(left + 1);
                int twoF = fibonacci(left);
                res = (num - twoF) > (oneF - num) ? (oneF - num) : (num - twoF);
            }
            System.out.println(res);
        }
    }

    public static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
