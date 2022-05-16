package com.leetcode.hashset;

import java.util.Set;
import java.util.TreeSet;


/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //TreeSet是有序的
        Set<Integer> set = new TreeSet<>();
        //将数组放到set里面去重
        for (int num : nums) {
            set.add(num);
        }
        int i=0;
        //在原数组的基础上赋值
        for (Integer num: set) {
            nums[i++] = num;
        }
        return set.size();

    }
}
