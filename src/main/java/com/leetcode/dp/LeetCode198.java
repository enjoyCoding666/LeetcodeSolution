package com.leetcode.dp;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\25 0025 23:55
 * @Description:
 */
public class LeetCode198 {
	public int rob(int[] nums) {
		if(nums==null) {
			return 0;
		}
		int length=nums.length;
		if(length==0){
			return 0;
		}
		if(length==1) {
			return nums[0];
		}
		//状态数组，表示经过前i个房屋中能抢劫到的最大数额。
		int[] dp=new int[length];
		//初始值
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0],nums[1]);
		for(int i=2;i<length;i++){
			//状态转移方程
			dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1] );
		}
		return dp[length-1];
	}
}
