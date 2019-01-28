package com.github.lintcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/26/19 22:08
 * @Description: Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Example
 * Example1
 * <p>
 * Input:
 * LRUCache(2)
 * set(2, 1)
 * set(1, 1)
 * get(2)
 * set(4, 1)
 * get(1)
 * get(2)
 * Output:
 * [1,-1,1]
 */
public class Lintcode134 {
    class LRUCache {
        int capacity;
        DoublelyListNode head = new DoublelyListNode(-1, -1);
        DoublelyListNode tail = new DoublelyListNode(-1, -1);
        Map<Integer, DoublelyListNode> map = new HashMap<>();

        /*
        * @param capacity: An integer
        */
        public LRUCache(int capacity) {
            // do intialization if necessary
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            if (!map.containsKey(key)) {
                return -1;
            }
            DoublelyListNode current = map.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;

            move_to_tail(current);
            return current.val;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
            if (get(key) != -1) {
                map.get(key).val = value;
                return;
            }
            if (map.size() == capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            DoublelyListNode node = new DoublelyListNode(key, value);
            map.put(key, node);
            move_to_tail(node);
        }

        public void move_to_tail(DoublelyListNode current) {
            current.prev = tail.prev;
            tail.prev.next = current;
            current.next = tail;
            tail.prev = current;
        }

        class DoublelyListNode {
            DoublelyListNode prev;
            DoublelyListNode next;
            int key;
            int val;

            public DoublelyListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
