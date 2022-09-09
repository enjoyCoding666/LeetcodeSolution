package com.leetcode.test;

public class MaxLongSubTest {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int[] dp = new int[nums.length];
            dp[0]= nums[i-1];
            for (int j = i; j < nums.length; j++) {
                dp[j] = Math.max(nums[j], dp[j - 1] + nums[j]);
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
        }
        return max;

    }
}
