package com.leetcode.linkedlist;

public class LeetCode140 {

    /**
     *  给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
     *
     *
     * */
    public ListNode trainingPlan(ListNode head, int cnt) {
        int size = 0;
        ListNode node = null;
        //先算出链表的长度
        for (node = head; node != null; node = node.next) {
            size++;
        }
        //如果 size 等于 cnt，那说明已经到了链表的倒数第 cnt 个。
        for (node = head; node != null && size > cnt; size--) {
            node = node.next;
        }
        return node;
    }

}
