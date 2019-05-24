package com.qqy.search;

/**
 * 有一个整数数组，根据快排的思路，找出第K大个数
 * 方法二
 *   思路
 *      先将数组快排一轮(大的数置左，小的置右），取到基准值的位置index，将index与k比较
 *          a.index+1==k，返回index处的值
 *          b.index+1<k，只在右半部分快排（index+1，right）
 *          c.index+1>k，只在左半部分快排（left，index-1）
 * Author:qqy
 */
public class FindKth1 {
    public static int findKth(int[] a, int n, int K) {
       return find(a,0,n-1,K);
    }

    public static int find(int[]a,int left,int right,int K){
        int index=sort(a,left,right);
        if(index+1==K){
            return a[index];
        }else if(index+1<K){
            return find(a,index+1,right,K);
        }else{
            return find(a,left,index-1,K);
        }
    }

    public static int sort(int[] arr,int left,int right){
        //基准值
        int key=arr[left];
        while(left<right){
            while(arr[right]<=key&&left<right){
                right--;
            }
            arr[left]=arr[right];
            while(arr[left]>=key&&left<right){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=key;
        return left;
    }

    public static void main(String[] args) {
        int[] arr={5,8,7,4,1,2,3,6,9};
        System.out.println(findKth(arr,9,2));
    }
}
