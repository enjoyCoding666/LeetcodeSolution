package com.leetcode.linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class LeetCode21Test {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //虚拟节点
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        //迭代法
        while (l1 != null && l2 != null) {
            //由于l1跟l2都是升序链表，所以可以对比哪个链表的节点值小，小的就加到结果的链表上面
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = (l1 == null ? l2 : l1);

        return prehead.next;
    }

}
