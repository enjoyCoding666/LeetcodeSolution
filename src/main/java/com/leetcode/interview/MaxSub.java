package com.leetcode.interview;


/**
 *
 * 最长子串
 *
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * 示例1
 * 
 * 输入：
 * 
 * "1AB2345CD","12345EF"
 * 
 * 返回值：
 * 
 * "2345"
 */
public class MaxSub {

    /**
     * 详情见： https://blog.csdn.net/weixin_44602933/article/details/119918453
     */
    public String LCS(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l1 = str1.length();
        int l2 = str2.length();
        //先确定状态，f(i, j)表示str1中前i个字符和str2中前j个字符中的最长公共子序列的长度
        //注意数组长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        StringBuilder res = new StringBuilder();
        int last1 = 0;
        int max = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    //状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    //记住最长子串的首尾下标
                    max = dp[i][j];
                    last1 = i;
                }
            }
        }

        for (int i = last1 - max; i < last1; i++) {
            res.append(s1[i]);
        }
        return res.toString();
    }

}
