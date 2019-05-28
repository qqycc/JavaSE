package com.qqy.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找出n个数里最小的k个
 * 思路
 *      从小到大排序，输出前k个
 * Author:qqy
 */
public class MinKth {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        List<Integer> list=new ArrayList<Integer>();
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
        int k=list.get(list.size()-1);
        list.remove(list.size()-1);
        //将list转化为数组
        Integer[] arr=list.toArray(new Integer[0]);
        bubbleSort(arr);
        for(int j=0;j<k;j++){
            System.out.print(arr[j]+" ");
        }
    }
    public static void bubbleSort(Integer[] array) {
        //假设有序
        boolean flag = true;
        //外部循环一共需要n-1次冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            //外部循环第i次需要比较n-2-i次
            for (int j = 0; j < array.length - 1 - i; j++) {
                //将两个数字中较大的置后
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;

                    //进入到if中，则表明有数字进行交换,无序
                    flag = false;
                }
            }
            //有序，退出循环
            if (flag) {
                break;
            }
        }
    }
}
