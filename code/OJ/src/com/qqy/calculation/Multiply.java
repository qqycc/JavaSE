package com.qqy.calculation;

/**
 * 构建乘积数组
 * 思路
 *      方法一：
 *          分别利用循环，先计算每一行的下三角形，在计算每一行的上三角形，两者相乘
 *      方法二：
 *          利用两次嵌套循环，碰到A、B数组下标相等的时候跳过，剩下的依次相乘
 * Author:qqy
 */
public class Multiply {
    //时间复杂度O(n)
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }

    //时间复杂度O(n^2)
    public static int[] multiply1(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0) {
            for (int i = 0; i < A.length; i++) {
                B[i]=1;
                for (int j = 0; j < A.length; j++) {
                    if(i==j){
                        continue;
                    }
                    B[i] *=A[j];
                }
            }
        }
        return B;
    }
}
