package com.leetcode.linkedlist;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode  fast = head.next;
        while (fast != slow) {
            //如果快指针走完了链表，说明链表不是环形的
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果快慢指针相遇，说明链表是环形的
        return true;
    }
}