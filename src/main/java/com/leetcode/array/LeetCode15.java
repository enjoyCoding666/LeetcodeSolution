package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 *
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //排序
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        //假如三数为(a,b,c), 首先枚举 第一个数a
        //关键思路：排序+双指针。要找出三数之和为0，可以先固定最左边的数，然后用双指针找到剩下两个数
        for (int first = 0; first < n; ++first) {
            //需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //双指针
            //第三个数c对应的指针初始指向数组的最右端
            int third = n - 1;
            // target是第二个数b和第三个数c的和。
            int target = -nums[first];
            //枚举第二个数 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //需要保证 b的指针在 c的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                //如果指针重合，随着b后续的增加
                //就不会有满足 a+b+c=0 并且 b<c 的c了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    resultList.add(list);
                }

            }
        }

        return resultList;

    }


}
