package com.leetcode.dp;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\30 0030 23:41
 * @Description:
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 */
public class LeetCode279 {
	public int numSquares(int n) {
		if(n<=0){
			return 0;
		}
		int[] dp=new int[n+1];
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			dp[i]=i;
			for(int j=1;i-j*j>=0;j++){
				// 观察比N小的数，且符合N = j*j + k 的数值,把最优解（最小值）加 1 就可以了。
				// 比如12 = 1 + 11 , 12 = 4 + 8 , 12 = 9 + 3. 只要得出3，8，11中谁的解最优，那么12的解就是它+1。
				dp[i]=Math.min(dp[i],dp[i-j*j]+1);

			}
		}
		return dp[n];
	}
}
