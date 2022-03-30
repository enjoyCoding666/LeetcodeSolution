package com.leetcode.linkedlist;

public class LeetCode206Iterator {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     * 思路：
     * While you are traversing the list, change the current node's next pointer to point to its previous element.
     * Since a node does not have reference to its previous node, you must store its previous element beforehand.
     * You also need another pointer to store the next node before changing the reference. Do not forget to return the new head reference at the end!
     *
     */
    public  ListNode reverseList(ListNode head){
        //上一个节点
        ListNode prev=null;
        //当前节点
        ListNode curr=head;
        while( curr!=null) {
            //先记住下一个节点
            ListNode nextNode= curr.next;
            //将当前节点指向上一个节点，形成反转
            curr.next= prev;
            //向后迭代
            prev= curr;
            curr= nextNode;
        }
        return prev;
    }
}
