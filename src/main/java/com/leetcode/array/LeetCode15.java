package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if( nums==null) {
            return null;
        }
        //排序，从小到大
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //要找出三数之和为0，可以先固定最左边的数，然后用双指针找到剩下两个数
        //数据是递增的， k < nums.length - 2是为了保证后面还能存在两个数字
        for(int k=0;k<nums.length -2;k++) {
            //如果最小的数都大于0，那三数之和肯定大于0.
            if(nums[k]>0) {
                break;
            }
            //三数不能重复
            if (k>0 && nums[k] == nums[k-1]) {
                continue;
            }
            //左右指针
            int i=k+1;
            int j=nums.length -1;
            while (i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum<0) {
                    //左指针前进，并去重
                    while (i<j && nums[i]== nums[++i]);
                } else if (sum>0) {
                    //右指针后退，并去重
                    while (i<j && nums[j] == nums[--j]);
                } else {
                    list.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i<j && nums[i]== nums[++i]);
                    while (i<j && nums[j] == nums[--j]);
                }

            }

        }

        return list;
    }
}
