package com.leetcode.linkedlist;


/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int[] nodes = new int[1000];
        int t = 0;
        //迭代链表，将数据复制到数组
        while (head != null) {
            nodes[t++] = head.val;
            head = head.next;
        }
        //判断是否回文
        for (int i = 0; i < t; i++) {
            if (nodes[i] != nodes[t - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
