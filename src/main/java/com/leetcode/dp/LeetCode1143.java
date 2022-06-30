package com.leetcode.dp;


/**
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 *     例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 *
 * 提示：
 *
 *     1 <= text1.length, text2.length <= 1000
 *     text1 和 text2 仅由小写英文字符组成。
 *
 *
 *
 */
public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //对于字符串text1对应的字符数组s1[i]，可以用s[0..i-1]表示从下标0到i-1的子序列。
        // 定义dp[i][j]的含义： 对于 s1[0..i-1]和s2[0..j-1]，
        // 它们的lcs(longestCommonSubsequence，也就是最长公共子序列)长度是 dp[i][j]
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <=n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //如果s[i]==s[j],那么这个公共字符一定在lcs中
                    //举个例子， text1为 abc， text2为 afc，
                    //那么 dp[2][2]，表示 ab和af的最长公共子序列。
                    //dp[3][3] 表示 abc和afc的最长公共子序列。
                    //新增加的字符都是c，明显 dp[3][3] = dp[2][2]+1;
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    //如果s[i]!=s[j]，那么说明s1[i]和s2[j]至少有一个不在lcs中，
                    // lcs的长度没有变大。只能取 dp[i - 1][j], dp[i][j - 1]中较大的值。
                    //举个例子， text1为 abcde， text2为 aczex，
                    //dp[4][5]，表示 abcd和aczex的最长公共子序列，结果为 ac，长度为2，
                    //dp[5][4]，表示 abcde和acze的最长公共子序列，结果为 ace，长度为3，
                    // 那么dp[5][5]为3.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[m][n];
    }
}
