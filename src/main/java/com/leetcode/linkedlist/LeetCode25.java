package com.leetcode.linkedlist;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //链表分区为 已翻转部分+待翻转部分+未翻转部分!!(重点)
        //初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
        if (head==null || head.next ==null) {
            return head;
        }
        //定义一个假的节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        while(end.next!=null) {
            //循环k次，找到需要翻转的链表的结尾
            for (int i=0; i<k && end!=null;i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点小于k，不执行翻转
            if (end==null) {
                break;
            }

            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;

            //反转链表
            pre.next = reverse(start);

            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点？？即start
            pre=start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点？？即start
            end=start;

        }


        return dummy.next;

    }

    /**
     *  反转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
