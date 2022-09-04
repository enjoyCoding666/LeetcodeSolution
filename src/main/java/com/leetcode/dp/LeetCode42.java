package com.leetcode.dp;

/**
 * 鼎鼎大名的接雨水。。
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 *
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n=height.length;
        //对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
        // 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
        int[] leftMax = new int[n];
        //初始化最左边的最大值
        leftMax[0] = height[0];
        //计算出下标左边最高的高度
        for (int i = 0; i <n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        //初始化最右边的最大值
        rightMax[n - 1] = height[n - 1];
        //计算出下标右边的最高高度。
        //从最右边开始，逐步往左.n - 1的值已经知道了，注意下标是 n-2 开始。
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        int ans = 0;
        //计算出两边高度差的最小值
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;

    }
}
