package com.leetcode.linkedlist;

public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode leftPrev = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            leftPrev = leftPrev.next;
        }

        // 第 2 步：从 leftPrev 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = leftPrev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个链表
        ListNode leftNode = leftPrev.next;
        ListNode rightNext = rightNode.next;

        // 注意：切断链接
        leftPrev.next = null;
        rightNode.next = null;

        // 第 4 步：反转链表
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中。左边变成了右边，因此左边上一个节点 leftPrev 指向之前的右节点。
        leftPrev.next = rightNode;
        leftNode.next = rightNext;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            //先记住下一个节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }



}
