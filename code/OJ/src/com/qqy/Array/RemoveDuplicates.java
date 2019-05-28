package com.qqy.array;

/**
 * 给定一个排序数组，在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间
 * Author:qqy
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int len=1;
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[index++]=nums[i];
                len++;
            }
        }
        return len;
    }
}
