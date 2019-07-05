package com.qqy.calculation;

import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum，求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样，就认为是不同的组成方案。
 * 第一行为两个正整数n（1sn≤1000），sum（1≤sum≤1000）
 * 第二行为n个正整数A[i]（32位整数），以空格隔开。
 * Author:qqy
 */
public class SumPlan {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int sum=in.nextInt();

            int[] A=new int[n+1];
            for(int i=1;i<=n;i++){
                A[i]=in.nextInt();
            }

            long[] d=new long[sum+1];
            d[0]=1;
            for(int i=1;i<=n;i++){
                for(int j=sum;j>=A[i];j--){
                    d[j]=d[j]+d[j-A[i]];
                }
            }
            System.out.print(d[sum]);
        }
    }
}
