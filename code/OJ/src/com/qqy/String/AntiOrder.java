package com.qqy.String;

/**
 * 有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 计算给定数组中的逆序对个数。
 * 给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 * Author:qqy
 */
public class AntiOrder {
    public static int count(int[] A, int n) {
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5,6,7,0};
        System.out.println(count(A,8));
    }
}
