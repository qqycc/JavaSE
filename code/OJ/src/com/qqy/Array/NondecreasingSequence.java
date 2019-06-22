package com.qqy.array;

/**
 * 给定一个长度为 n 的整数数组，判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 定义一个非递减数列： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 思路：
 *      相邻数两个改变，前者变小/后者变大
 * Author:qqy
 */
public class NondecreasingSequence {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1 && count < 2; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,5,4};
        System.out.println(checkPossibility(arr));
    }

}