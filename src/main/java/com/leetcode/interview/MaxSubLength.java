package com.leetcode.interview;


/**
 *
 *
 * 两个字符串，求出两个字符串最长公共字串的长度。
 * 例如：
 * 输入：abcdbeac acdbcdb
 * 输出：3
 *
 *
 */
public class MaxSubLength {

    /**
     * 详情见 https://blog.csdn.net/weixin_44602933/article/details/119918453
     *
     */
    public int getMaxSubLength(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l1 = str1.length();
        int l2 = str2.length();
        //先确定状态，f(i, j)表示str1中前i个字符和str2中前j个字符中的最长公共子序列的长度
        int[][] dp = new int[l1+1][l2+1];
        int max = 0;
        for(int i = 1; i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if (s1[i - 1] == s2[j - 1]) {
                    //状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if(dp[i][j]>max){
                    max = dp[i][j];

                }
            }
        }
        return max;
    }
}
