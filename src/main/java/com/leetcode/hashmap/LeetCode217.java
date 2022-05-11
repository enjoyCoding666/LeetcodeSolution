package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums==null) {
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {
            if(map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
