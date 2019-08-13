package com.qqy.array;

import java.util.ArrayList;


/**
 * 最小的k个数
 * Author:qqy
 */
public class MinKth {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,5,1,2,4,7,9,6},4));
    }
    public static ArrayList<Integer> solution(int[] input,int k){
        ArrayList<Integer> list=new ArrayList<>();
        if(k>input.length){
            return list;
        }
        for(int j=0;j<k;j++){
            int min=0;
            for(int i=1;i<input.length-j;i++){
                if(input[i]<input[min]){
                    min=i;
                }
            }
            list.add(input[min]);
            int temp=input[min];
            input[min]=input[input.length-j-1];
            input[input.length-j-1]=temp;
        }
        return list;
    }
}
