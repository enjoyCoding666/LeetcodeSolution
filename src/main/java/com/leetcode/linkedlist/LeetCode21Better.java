package com.leetcode.linkedlist;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 */
public class LeetCode21Better {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) {
            return list2;
        }
        if (list2==null) {
            return list1;
        }
        if (list1.val < list2.val) {
            //要判断 list1 和 list2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
            list1.next = mergeTwoLists (list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists (list1, list2.next);
            return list2;
        }

    }
}
