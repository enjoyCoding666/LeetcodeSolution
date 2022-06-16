package com.leetcode.hashtable;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 *
 * 提示：
 *
 *     0 <= s.length <= 5 * 104
 *     s 由英文字母、数字、符号和空格组成
 *
 *
 *
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        //26个字母的字符数组，字符c-' '表示索引的下标，元素的值表示出现的次数。
        char[] countChars = new char[200];
        int count = 1;
        int max = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //遍历子字符串
            for (int j = i; j >= i && j < charArray.length; j++) {
                char c = charArray[j];
                int k = c - ' ';
                if (countChars[k] > 0) {
                    //字符重复出现就停止，算出目前的最大长度
                    max = count > max ? count : max;
                    count = 0;
                    //从下一个i开始计数，之前的字符出现数量要置零
                    countChars = new char[200];
                    break;
                }
                countChars[k]++;
                count++;
            }
        }

        return max;
    }
}
