package com.leetcode.dp;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\6\3 0003 22:38
 * @Description:
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 */
public class LeetCode53 {
	public int maxSubArray(int[] nums) {
		int length=nums.length;
		//dp[i]表示以第i个元素结尾的子数组的最大值，注意是结尾
		int[] dp=new int[length];
		dp[0]=nums[0];
		int maxSum=nums[0];
		for(int i=1;i<length;i++) {
			//状态转移方程，由于子数组是以nums[i]结尾，所以可能是dp[i-1]+nums[i]，也可能是nums[i]
			dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
			//找出不同的数组元素结尾的最大值。
			maxSum=Math.max(dp[i],maxSum);
		}
		return maxSum;
	}
}
