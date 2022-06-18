package com.leetcode.dp;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\31 0031 12:12
 * @Description:
 */
public class LeetCode70 {
	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] dp = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			//走到i-1阶，再走1步1阶，就可以达到i阶。
			//走到i-2阶，再走1步2阶，就可以达到i阶，而再走2步1阶的，已经包含在i-1阶的走法里面了。
			//因此，第i阶楼梯的走法，其实就是第i-1阶的走法加上第i-2阶的走法。
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
