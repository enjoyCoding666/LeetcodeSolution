package com.leetcode.dp;


/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 */
public class LeetCode5 {


    /**
     * 对于一个子串而言，如果它是回文串，并且长度大于 2，那么将它首尾的两个字母去除之后，它仍然是个回文串。
     *
     * P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串。(s[i:j] 类似)
     *
     * (1)状态转移方程：
     *
     * P(i,j)=P(i+1,j−1)∧(Si==Sj)
     * 也就是：只有 s[i+1:j−1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串。
     *
     * (2)初始值：
     * 对于长度为 1 的子串，它显然是个回文串；
     * 也就是 P(i,i)=true;
     *
     * 对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件：
     * 也就是P(i,i+1)=  (Si==Si+1)
     *
     * 详情见： https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;

        // dp[i][j] 表示从字符数组的下标i开始到下标j的子序列 s[i,i+1,..j] 是否是回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子序列的长度
        for (int subLength = 2; subLength <= length; subLength++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int left = 0; left < length; left++) {
                // 由 subLength 和 left 可以确定右边界，即 right - left + 1 = subLength 得
                int right = subLength + left - 1;
                // 如果右边界越界，就可以退出当前循环
                if (right >= length) {
                    break;
                }

                if (charArray[left] != charArray[right]) {
                    //子序列的左边界和右边界的值，如果不相同，就不可能是回文串
                    dp[left][right] = false;
                } else {
                    //左边界和右边界相同时，子序列的长度为1或为2，都是回文串。
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        //状态转移方程，左边界和右边界相同时，
                        // 从left到right的子序列，跟从left + 1 到 right - 1的子序列，要么都是回文串，要么都不是回文串。
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                // 只要 dp[left][subLength] == true 成立，就表示子串 s[left..subLength] 是回文，此时记录回文长度和起始位置
                if (dp[left][right] && right - left + 1 > maxLength) {
                    //找出最大子序列的长度
                    maxLength = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /**
     *
     * 注意点：
     * * (1)定义 boolean 数组 dp[i][j]。
     * // dp[i][j] 表示 s[i..j] 这个子串是否是回文串
     * boolean[][] dp = new boolean[len][len];
     *
     * (2)先初始化所有长度为1的。
     * (3)遍历两次，不同的长度，以及不同的左下标，逐步递推。这个比较特别
     * (4)状态转移方程：  dp[i][j] = dp[i + 1][j - 1];
     * (5) 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置。
     *
     *
     */

}
