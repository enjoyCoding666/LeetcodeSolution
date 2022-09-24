package com.leetcode.interview;

/**
 * 判断一个数是不是斐波那契数
 *
 * 斐波纳契数列，又称黄金分割数列，指的是这样一个数列：1、1、2、3、5、8、13、21、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：F0=1，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）。
 *
 */
public class Fibonacci {

    /**
     * 这道题挺简单的。就是要注意一些边界值。
     * @param num
     * @return
     */
    public boolean isFibo(int num) {
        //负数检查
        if (num<=0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int[] dp = new int[num];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<num;i++) {
            dp[i]= dp[i-1] + dp[i-2];
            if (dp[i] == num) {
                return true;
            } else if (dp[i] > num) {
                //超出范围了就不再检测
                return false;
            }
        }
        return false;


    }
}
