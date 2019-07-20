package com.qqy.array;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * Author:qqy
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner;
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            String[] strs = in.nextLine().split(" ");
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(maxSubArray(nums));
        }
    }
}
