package com.leetcode.dp;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\19 0019 23:33
 * @Description:
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
public class LeetCode121 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		// 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
		// 1：用户手上持股所能获得的最大利润

		// 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
		//状态数组如下：
		int[][] dp = new int[len][2];
		//初始值如下：
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < len; i++) {
			//推演出的"状态转移方程"如下
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[len - 1][0];
	}
}
