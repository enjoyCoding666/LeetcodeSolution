package com.leetcode.sort;

import com.leetcode.linkedlist.ListNode;


/**
 * 重排链表
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *
 *
 *
 */
public class LeetCode143 {

    public void reorderList(ListNode head) {
        if (head==null) {
            return;
        }
        //找出中间节点
        ListNode mid = middleNode (head);
        ListNode second = mid.next;
        mid.next = null;

        //反转链表
        second = reveserList( second);
        //合并链表
        mergeList(head, second);

    }

    /**
     *  中间节点
     */
    public ListNode middleNode (ListNode head) {
        if (head== null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next !=null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    /**
     *  反转链表
     */
    public ListNode reveserList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null) {
            //记住下一个节点
            ListNode next = curr.next;
            //当前节点指向上一个节点
            curr.next = prev;
            //向后迭代,当前节点变为下一个节点，上一个节点变为当前节点
            prev = curr;
            curr = next;
        }
        return prev;

    }

    /**
     *  合并链表。 first 为 1->2 ,second 为 4->3， 先用 first 的第一个节点 1 连接 second 的第一个节点 4，
     * 再用 second 的第一个节点 4 连接 first 的下一个节点 2. 最后变成  1-> 4-> 2-> 3.
     */
    public void mergeList ( ListNode first , ListNode second) {
        ListNode firstTemp;
        ListNode secondTemp;

        while (first!=null && second!=null) {
            firstTemp = first.next;
            secondTemp = second.next;

            first.next = second;
            first = firstTemp;

            second.next = first;
            second = secondTemp;
        }

    }



}
