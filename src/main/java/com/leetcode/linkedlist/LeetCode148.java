package com.leetcode.linkedlist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序链表。
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 */
public class LeetCode148 {

    public ListNode sortList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode curr = head;
        //链表先转换成 集合
        List<Integer> list = new ArrayList<>();
        while (curr!=null) {
            list.add(curr.val);
            curr = curr.next;
        }
        //集合转换为数组
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        //对数组进行排序
        Arrays.sort(array);

        int k = 0;
        curr = head;
        //遍历链表，重新赋值
        while (curr!=null) {
            curr.val = array[k];
            curr = curr.next;
            k++;
        }
        return head;

    }


}
