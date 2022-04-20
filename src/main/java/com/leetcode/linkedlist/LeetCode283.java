package com.leetcode.linkedlist;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0, j=0; i < nums.length; i++) {
            //如果元素为零，j记录为零的下标。
            //如果元素不为0，i,j一起动。
            //i>=j，交换数据后，非零元素会一直左移，相当于0在右移
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }

        }
    }

}
