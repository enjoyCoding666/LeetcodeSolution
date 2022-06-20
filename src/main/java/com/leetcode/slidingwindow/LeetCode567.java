package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;


/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     1 <= s1.length, s2.length <= 104
 *     s1 和 s2 仅包含小写字母
 *
 *
 *
 */
public class LeetCode567 {


    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Maps = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            //s1Maps记录s1字符串的字母出现次数
            s1Maps.put(c, s1Maps.getOrDefault(c, 0) + 1);
        }
        int left = 0, right=0, windowSize=0;
        //遍历s2字符串
        while (right < s2.length()) {
            //右指针对应的字符串
            char c = s2.charAt(right);
            //右指针继续右移
            right++;

            if (s1Maps.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (s1Maps.get(c).equals(window.get(c))) {
                    windowSize++;
                }
            }
            //只有在right - left == need.size()的情况下才有可能有符合条件的解
            while (right - left == s1.length()) {
                if (windowSize == s1Maps.size()) {
                    //窗口的长度跟s1的长度一样时就说明是子串
                    return true;
                }
                char lastLeftChar = s2.charAt(left);
                //滑动窗口想要向右移，左指针就得向右移
                left++;
                if (s1Maps.containsKey(lastLeftChar)) {
                    if (s1Maps.get(lastLeftChar).equals(window.get(lastLeftChar))) {
                        windowSize--;
                    }
                    //滑动窗口的整体长度是不变的，要向右移，只能把最左边的字符去掉
                    window.put(lastLeftChar, window.getOrDefault(lastLeftChar, 0) - 1);
                }

            }
        }
        return false;

    }

}
