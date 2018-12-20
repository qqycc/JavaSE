package com.qqy.feature;

/**
 * foreach循环
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5};
        for (int anIntArray : intArray) {
            //每次循环（intArray）的时候会将数组中的元素赋值给变量（anIntArray）
            System.out.println(anIntArray);
        }
    }
}


