package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        long num = 0;
        //遍历，计算各位数的总和
        for (int i = 0; i < digits.length; i++) {
            //幂运算
            num += digits[i] * Math.pow(10, digits.length-1-i);
        }
        num += 1;
        int length = String.valueOf(num).length();
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            //遍历并将各位数放到list中
            list.add((int) (num % 10));
            num /= 10;
        }
        int[] nums = new int[length];
        //反向
        for (int i = 0; i < length; i++) {
            nums[length -1- i] = list.get(i);
        }
        return nums;

    }

}
