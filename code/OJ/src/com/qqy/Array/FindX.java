package com.qqy.array;

import java.util.Scanner;

/**
 * 输入一个数n，然后输入n个数值各不相同
 * 再输入一个值x，输出这个值在这个数组中的下标
 * （从0开始，若不在数组中则输出-1）。
 * Author:qqy
 */
public class FindX {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while(in.hasNext()){
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int element=in.nextInt();
            System.out.println(find(n,element,arr));
        }
    }

    public static int find(int n,int element,int[] arr){
        for(int i=0;i<n;i++){
            if(element==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
