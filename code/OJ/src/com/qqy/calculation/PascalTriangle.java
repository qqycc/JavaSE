package com.qqy.calculation;

import java.util.Scanner;

/**
 * 每个数等于它上方两数之和
 * 每行数字左右对称，由1开始逐渐变大
 * 第 n 行的数字有 n 项
 * 方法一：非递归实现
 *  思路：
 * 1.由于既有行又有列，且便于查找，首先想到的是利用二维数组进行杨辉三角形的构建。
 * 2.找规律：[n][0]=[n][n]=1,[n][m]=[n-1][m-1]+[n-1][m]
 * 3.利用双重循环
 * 方法二：递归实现
 * 方法三：
 *  思路：
 *      二项式展开式的各项系数就是杨辉三角形，只需要计算各项的系数C(n,m)
 * Author:qqy
 */
public class PascalTriangle {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int m=in.nextInt();
            System.out.println(pascal(n,m));
            System.out.println(recursionPascal(n,m));
            System.out.println(coefficient(n,m));
        }
    }

    public static int pascal(int n, int m) {
        int[][] triangle = new int[n][n];
        //每行的第一个和最后一个数字为1
        if (n == m || (m - 1) == 0) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                if (m - 1 > i / 2) {
                }
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle[n - 1][m - 1];
    }

    public static int recursionPascal(int n, int m) {
        //每行的第一个和最后一个数字为1
        if (n == m || (m - 1) == 0) {
            return 1;
        }
        return recursionPascal(n - 1, m - 1) + recursionPascal(n - 1, m);
    }

    public static int coefficient(int n,int m){
            int former=1;
            for(int j=0;j<n;j++){
                if(j==m-1){
                    return former;
                }
                //根据系数C(n,m)的求解，可得下式
                former=former*(n-1-j)/(j+1);
            }
        return -1;
    }
}
