package com.leetcode.sort;


import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 *
 * 提示:
 *
 *     1 <= s.length, t.length <= 5 * 104
 *     s 和 t 仅包含小写字母
 *
 *
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] charsA = s.toCharArray();
        char[] charsB = t.toCharArray();
        //排序
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        //如果是字母异位词，排序后的字符数组是相同的。
        return Arrays.equals(charsA,charsB);

    }

}
