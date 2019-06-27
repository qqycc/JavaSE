package com.qqy.array;

/**
 * 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路一：
 *  遍历每行，利用二分查找每行。
 * 思路二：
 *  利用二维数组由上到下，由左到右递增的规律，
 *      那么选取右上角或者左下角的元素a[row][col]与target进行比较，
 *      当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
 *      即col--；
 *      当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
 *      即row++；
 * Author:qqy
 */
public class FindNumTwoDimensional {
    public static boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            if(FindLine(i,array,target)){
                return true;
            }
        }
        return false;
    }
    public static boolean FindLine(int i,int[][]array,int target){
        int left=0;
        int right=array[i].length-1;
        int mid;
        while(right>=left){
            mid=(right-left)/2+left;
            if(array[i][mid]>target){
                right=mid-1;
            }else if(array[i][mid]<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Find2(new int[][]{{1,2,8,9},{3,7,10,13}},7));
    }

    public static boolean Find2(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col]) {
                return true;
            }
            else if(target>array[row][col]) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}
