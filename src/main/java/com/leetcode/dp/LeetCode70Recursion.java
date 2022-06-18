package com.leetcode.dp;

public class LeetCode70Recursion {
    /**
     *
     * 爬楼梯的递归解法。
     * 执行时间随着 n的增大，指数级上升。
     *
     * 以此可以对比，动态归划的"空间换时间"。
     *
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);


    }
}
