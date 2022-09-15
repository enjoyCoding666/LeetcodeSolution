package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3Test {

    public int getMaxLength(String s) {
        if (s==null) {
            return 0;
        }
        if (s.length()==1) {
            return 1;
        }
        //采用哈希表法，key是字符，value是下标
        Map<String,Integer> map = new HashMap<>();
        int max =0;
        int left =0;
        for (int i=0;i<s.length();i++) {
            String c = String.valueOf(s.charAt(i));
            if(map.containsKey(c)) {
                //如果有重复，就计算最大长度
                max = Math.max (max, i-left);
                left = Math.max (left, map.get(c)+1);
            }
            //设置字符的最新下标
            map.put(c, i);

        }
        return max;
    }
}
