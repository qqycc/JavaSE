package com.qqy;

import java.util.Scanner;

/**
 * 最长的数字递增子数组
 * Author:qqy
 */
public class MaxNumberArray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            String[] arr=str.split(" ");
            int max=0;
            int end=0;
            int count=1;
            for(int i=0;i<arr.length-1;i++){
                if(Integer.parseInt(arr[i])<Integer.parseInt(arr[i+1])){
                    count++;
                    if(count>=max){
                        if(count==max){
                            for(int j=end-max+1;j<end+1;j++) {
                                System.out.print(arr[j]+" ");
                            }
                            System.out.println();
                        }
                        max=count;
                        end=i+1;
                    }
                }else{
                    count=1;
                }
            }
            for(int i=end-max+1;i<end+1;i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
