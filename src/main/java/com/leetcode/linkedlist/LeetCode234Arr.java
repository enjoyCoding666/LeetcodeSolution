package com.leetcode.linkedlist;

public class LeetCode234Arr {

    public boolean isPalindrome(ListNode head) {
        if (head==null) {
            return false;
        }
        //还是用 list 比较好。不用纠结下标
        int[] arr= new int[100000];
        int k=0;
        while (head!=null) {
            arr[k++]=head.val;
            head=head.next;
        }
        for (int i=0;i<k;i++) {
            if (arr[i]!=arr[k-1-i]) {
                return false;
            }
        }
        return true;
    }

}
