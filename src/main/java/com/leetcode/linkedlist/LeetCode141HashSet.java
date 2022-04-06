package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141HashSet {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //创建Set集合，泛型为 ListNode，放入所有的 ListNode 节点
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //每次遍历到一个节点时，判断该节点此前是否被访问过。
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;

    }
}
