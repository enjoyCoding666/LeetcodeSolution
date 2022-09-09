package com.leetcode.dp;

public class LeetCode53Better {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre= 0;
        int max= nums[0];
        for (int num: nums) {
            pre = Math.max(num, pre+num);
            max = Math.max(pre, max);
        }
        return max;
    }


}
