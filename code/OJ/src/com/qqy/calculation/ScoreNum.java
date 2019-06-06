package com.qqy.calculation;

import java.util.Scanner;

/**
 * 统计同成绩学生人数
 * Author:qqy
 */
public class ScoreNum {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int n=in.nextInt();
            if(n==0){
                System.out.println(0);
                break;
            }
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int count=0;
            int target=in.nextInt();
            for(int i=0;i<n;i++){
                if(arr[i]==target){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
