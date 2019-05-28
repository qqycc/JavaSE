package com.qqy.array;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * Author:qqy
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums==null){
            return 0;
        }
        int len=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index++]=nums[i];
                len++;
            }
        }
        return len;
    }
}
