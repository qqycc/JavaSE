package com.qqy.array;

import java.util.Arrays;

/**
 * 找出数组中过半的数字
 * Author:qqy
 */
public class MoreThanHalf {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count=array.length;
        int num=1;
        Arrays.sort(array);
        for(int i=1;i<count;i++){
            if(array[i-1]==array[i]){
                num++;
            }else{
                int temp=count%2==0?count/2:(count-1)/2;
                if(num>temp){
                    return array[i-1];
                }
                num=1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1}));
    }
}
