package com.leetcode.hashmap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 *  返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 *  可以不考虑输出结果的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 *
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1==null || nums2==null) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        //把数组元素出现的次数放到map里面，每出现一次，次数就加一
        for(int num: nums1) {
            int count = map.getOrDefault(num,0);
            map.put(num, ++count);
        }
        for(int num: nums2) {
            //如果map中含有数组元素，并且对应的value不为0，说明是两个数组相交的元素
            if (map.containsKey(num) && map.get(num)!=0) {
                list.add(num);
                //将map中的次数减一
                map.put(num, map.get(num)-1);
            }
        }
        //集合转化为数组
        return  list.stream().mapToInt(Integer::valueOf).toArray();

    }
}
