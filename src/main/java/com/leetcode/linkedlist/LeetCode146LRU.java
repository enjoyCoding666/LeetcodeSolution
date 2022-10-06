package com.leetcode.linkedlist;


import java.util.LinkedHashMap;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 *
 *     LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *     void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 *
 * 提示：
 *
 *     1 <= capacity <= 3000
 *     0 <= key <= 10000
 *     0 <= value <= 105
 *     最多调用 2 * 105 次 get 和 put
 *
 *
 *
 */
public class LeetCode146LRU {

    private int capacity;

    /**
     * 哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。
     * 结合一下，形成一种新的数据结构：哈希链表 LinkedHashMap
     *
     */
    private LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();


    /**
     * 构造方法，设置LRU的容量
     * @param capacity
     */
    public LeetCode146LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        //如果map里面没有，就直接返回
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        //将 key 变为最近使用
        makeRecently(key);
        return linkedHashMap.get(key);

    }


    public void put(int key, int val) {
        //主要分几种情况： 已存在，不存在
        if (linkedHashMap.containsKey(key)) {
            //修改key的值
            linkedHashMap.put(key, val);
            //将key变为最近使用
            makeRecently(key);
            return;
        }
        //超出边界
        if (linkedHashMap.size() >= this.capacity) {

            //链表头部就是最久未使用的key，此处用法多留意
            Integer oldestKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(oldestKey);
        }
        //将新的 key 添加到链表尾部
        linkedHashMap.put(key, val);

    }


    /**
     * 设置 key为最近使用
     * @param key
     */
    public void makeRecently(int key) {
        Integer val = linkedHashMap.get(key);
        //删除key，重新插入到队尾
        linkedHashMap.remove(key);
        linkedHashMap.put(key, val);

    }


}
