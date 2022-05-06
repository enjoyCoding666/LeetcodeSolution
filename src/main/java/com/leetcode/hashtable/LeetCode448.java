package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 *
 *  请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 *
 *
 * 提示：
 *
 *     n == nums.length
 *     1 <= n <= 105
 *     1 <= nums[i] <= n
 *
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内
 *
 *
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        //用哈希表，记录是否出现数值.
        for (int num : nums) {
            if (num <= length) {
                map.put(num, 1 );
            }
        }
        //如果数据没有在哈希表里出现，就放到list中。
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }

        return list;
    }

}
