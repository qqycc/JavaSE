package com.qqy.recursive;

/**
 * 递归求数组最大值
 * Author:qqy
 */
public class Max {
    public static int max(int i,int[] arr){
        if(i>= arr.length){
            return 0;
        }
        int max=arr[i];
        return max>max(i+1,arr)?max:max(i+1,arr);
    }

    public static void main(String[] args) {
        int[] arr={1,2,18,8,7,5,6,9};
        System.out.println(max(0,arr));
    }
}
