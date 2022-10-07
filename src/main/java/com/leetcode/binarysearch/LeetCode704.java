package com.leetcode.binarysearch;

public class LeetCode704 {


    /**
     * 二分查找法。时间复杂度：O(log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums==null) {
            return -1;
        }
        //二分查找,left,right,mid
        int left=0;
        int right = nums.length -1;
        int mid ;
        //注意，结束循环的条件是 左边界<=右边界
        while (left<=right) {
            //中间节点的下标
            mid = (right+left)/2 ;
            //如果 nums[i]=target，则下标 i 即为要寻找的下标；
            //如果 nums[i]>target，则 target 只可能在下标 i 的左侧；
            //如果 nums[i]<target，则 target 只可能在下标 i 的右侧。
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return -1;
    }

}
