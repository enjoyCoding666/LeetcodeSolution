package com.leetcode.linkedlist;

/**
 * 这是LeetCode中默认的链表。此处的next节点，最好还是使用setter、getter设置链表的下一个节点。
 */
 public class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) {
          val = x;
      }

      ListNode(int x,ListNode next) {
          val=x;
          this.next=next;
      }


 }