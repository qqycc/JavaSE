package com.qqy.Array;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 *
 * 思路：
 *      将nums2中的数依次插入nums1中
 * Author:qqy
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        while(i<n){
            for(;j<m;j++) {
                if(i==n){
                    break;
                }
                if (nums2[i] <nums1[j]){
                    for(int k=m;k>j;k--){
                        nums1[k]=nums1[k-1];
                    }
                    nums1[j]=nums2[i++];
                    m++;
                }
            }
            //nums1遍历完，将nums2剩下的全部加到nums1后面
            if(i==n){
                break;
            }
            nums1[j++]=nums2[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums1={2,0};
        int[] nums2={1};
        merge(nums1,1,nums2,1);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
    }
}
