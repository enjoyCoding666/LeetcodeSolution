package com.leetcode.linkedlist;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return head;
        }
        //使用一个虚拟节点，指向链表头
        ListNode fake = new ListNode(0, head);
        ListNode curr = fake;
        while ( curr.next!=null && curr.next.next!=null) {
            if (curr.next.val == curr.next.next.val) {
                //去掉重复节点
                int nodeVal = curr.next.val;
                //如果有重复数值，就跳过此节点，直接指向后续的节点。多个重复需要继续迭代处理
                while (curr.next!=null && curr.next.val == nodeVal) {
                    curr.next = curr.next.next;
                }
            } else {
                //没有重复节点，就直接遍历到下一个节点
                curr = curr.next;
            }
        }
        return fake.next;

    }

}
