package com.qqy.calculation;

/**
 * 二维数组的打印
 * Author:qqy
 */
public class Printer {
    public static int[] arrayPrint(int[][] arr, int n) {
        if( n==0 || arr==null) return null;
        int row = 0, col = n-1 ,index = 0;
        int []a = new int[n*n];
        while(row < n){
            int i = row ,j = col;
            while( i<n && j<n ){
                a[index++]=arr[i][j];
                i++;
                j++;
            }
            if(col>0) {
                col--; // 斜线开始位置的列 先向左移动
            }
            else {
                row++;//  列移动到最左之后 行向下移动
            }
        }
        return a;
    }
}
