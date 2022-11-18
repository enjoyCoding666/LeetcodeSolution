package com.leetcode.array;

public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m<0 || n<0) {
            return ;
        }
        int i=m-1;
        int j=n-1;
        for (int k=m+n-1;k>=0;k--) {
            //本质还是双指针.第二个数组，如果每个数都合并过了，那么就不用比较了。
            if (j<0 || (i>=0 && nums1[i]> nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
