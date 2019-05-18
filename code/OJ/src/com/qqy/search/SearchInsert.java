package com.qqy.search;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 假设数组中无重复元素。
 *
 * 思路：
 *      因为有序，如果从头遍历，
 *      1.遍历到第一个大于target的地方还没有找到，
 *          若这个数下标为0，则返回0
 *          否则，返回该处
 *      2.找到，则返回下标
 *      3.遍历完既没有找到target，也没有比target大的数，返回nums。length
 * Author:qqy
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
            if(nums[i]>target){
                if(i==0){
                    return 0;
                }else {
                    return i ;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] ar={1,3,5,6};
        System.out.println(searchInsert(ar,2));
    }
}
