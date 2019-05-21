package com.qqy.search;

/**
 * 有一个整数数组，根据快排的思路，找出第K大个数
 * Author:qqy
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        quickSort(a,0,n-1);
        int len=a.length;
        return a[len-K];
    }
    public static void quickSort(int[] array,int left,int right){
        if(left>=right){
            return;
        }

        int pivot=theMiddleOfThreeNumbers(array,left,right);
        swap(array,right,pivot);

        //获取每次排序后，基准值的位置
        int pivotIndex=partitionIndex(array,left,right);

        //小于基准值区间[left,pivotIndex-1]
        quickSort(array,left,pivotIndex-1);
        //大于基准值区间[pivotIndex+1,right]
        quickSort(array,pivotIndex+1,right);
    }

    public static int partitionIndex(int[] array,int left,int right){
        int small=left;
        int big=left;
        int pivot=array[right];
        while(big<right) {
            if (array[big] < pivot) {
                swap(array, small, big);
                small++;
            }
            big++;
        }
        swap(array,small,right);
        return small;
    }

    public static int theMiddleOfThreeNumbers(int[] array,int left,int right){
        int mid=left+(right-left)/2;
        if(array[left]<array[right]){
            if(array[left]>array[mid]){
                return left;
            }else if(array[right]<array[mid]){
                return right;
            }
        }else{
            if(array[left]<array[mid]){
                return left;
            }else if(array[right]>array[mid]){
                return right;
            }
        }
        return mid;
    }

    public static void swap(int[] array,int a,int b){
        int t=array[a];
        array[a]=array[b];
        array[b]=t;
    }
}
