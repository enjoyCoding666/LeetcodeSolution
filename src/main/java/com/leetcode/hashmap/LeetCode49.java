package com.leetcode.hashmap;

import java.util.*;


/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null) {
            return null;
        }
        Map<String, List<String> > map = new HashMap<>();
        for(String str:strs) {
            //字符串转字符数组
            char[] chars = str.toCharArray();
            //字符数组排序
            Arrays.sort(chars);
            //排序后的字符数组转字符串
            String key = new String(chars);
            //用字符串作key，用list作为value
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        //map.values()获取到map的所有value，也就是上面的list
        return new ArrayList<List<String>>(map.values());

    }
}
