package com.leetcode.linkedlist;


import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    class DoubleNode {
        int key;
        int value;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode() {
        }

        public DoubleNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DoubleNode> cache = new HashMap<Integer, DoubleNode>();
    private int size;
    private int capacity;
    private DoubleNode head, tail;

    public LeetCode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DoubleNode newNode = new DoubleNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DoubleNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoubleNode node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DoubleNode removeTail() {
        DoubleNode res = tail.prev;
        removeNode(res);
        return res;
    }

}



