package com.leetcode.linkedlist;


/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 */
public class LeetCode92Better {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //设置虚拟节点,指向首节点
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;

        ListNode pre = fakeNode;
        //找出要翻转的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //当前节点
        ListNode cur = pre.next;
        //下一个节点
        ListNode next ;
        //采用头插法，后面的节点一个接着一个往头部插入
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return fakeNode.next;
    }

}
