package com.leetcode.slidingwindow;

import java.util.HashMap;


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
public class LeetCode3Better {

    public int lengthOfSubstring(String s) {
        if (s == null) {
            return 0;
        }
        //Char的泛型是 Character，别写错了
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果出现重复的字符,就刷新滑动窗口的左下标.
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            //使用map记录字符的下标
            map.put(s.charAt(i), i);
            //i - left + 1表示非重复子串的长度
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

}
