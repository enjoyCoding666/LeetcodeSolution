package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;


/**
 *  3. 无重复字符的最长子串
 *
 *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
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
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        //滑动窗口
        Map<Character,Integer> window = new HashMap<>();
        //左指针
        int left=0;
        //右指针
        int right =0;
        //最大长度
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //右指针不断右移
            right++;
            //把字符串的数据放进滑动窗口
            window.put(c, window.getOrDefault(c,0)+1);
            //判断窗口是否存在重复数据
            while(window.get(c) >1) {
                //左指针对应的字符
                char d = s.charAt(left);
                //如果有重复数据，就调整左指针的位置
                left++;
                //由于左指针移动，窗口里对应的字符要去掉
                window.put(d, window.getOrDefault(d,0)-1);

            }

            max = Math.max(max, right-left);
        }
        return max;


    }
}
