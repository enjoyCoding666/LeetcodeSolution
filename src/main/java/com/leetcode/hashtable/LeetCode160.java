package com.leetcode.hashtable;

import com.leetcode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;


/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 *
 *
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //用哈希表，存放 ListNode 节点
        Set<ListNode> set = new HashSet<>();
        ListNode head = headA;
        while (head != null) {
            //哈希表，存放链表A的所有节点
            set.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            //如果存在相交的节点，那么节点会存在于set集合中
            if (set.contains(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
