package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 10
 *     -10 <= nums[i] <= 10
 *     nums 中的所有元素 互不相同
 *
 *
 *
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList= new ArrayList<>();
        backTrack(0, nums, resultList, new ArrayList<>());
        return resultList;

    }


    /**
     * 回溯法进行穷举
     *
     */
    public void backTrack(int i, int[] nums, List<List<Integer>> resultList, List<Integer> tmp) {
        //添加子集
        resultList.add(new ArrayList<>(tmp));
        for(int j=i;j<nums.length;j++) {
            //添加选择的元素
            tmp.add(nums[j]);
            //递归， 子集的下标从j+1开始遍历
            backTrack(j+1, nums, resultList, tmp);
            //回溯，撤消选择
            tmp.remove(tmp.size()-1);

        }

    }

}
