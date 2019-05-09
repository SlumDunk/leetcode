package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 10:30
 * @Description: Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LFUCache cache = new LFUCache( 2 );
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class Leetcode460 {
    class Node {
        int key;
        int val;
        int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class LFUCache {
        private Map<Integer, Node> values;
        private Map<Integer, Set<Integer>> freqs;
        private int minFreq = 1;
        private int cap;
        private int count = 0;

        public LFUCache(int capacity) {
            values = new HashMap<>();
            freqs = new HashMap<>();
            cap = capacity;
            freqs.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!values.containsKey(key)) {
                return -1;
            }
            Node node = values.get(key);
            freqs.get(node.freq).remove(key);
            node.freq++;
            if (!freqs.containsKey(node.freq)) {
                freqs.put(node.freq, new LinkedHashSet<>());
            }
            freqs.get(node.freq).add(key);
            //上一次的频率值是最小频率
            if (node.freq - 1 == minFreq && freqs.get(node.freq - 1).size() == 0) {
                minFreq = node.freq;
            }
            return node.val;
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }
            if (values.containsKey(key)) {
                values.get(key).val = value;
                get(key);
                return;
            }
            //已经满了
            if (count == cap) {
                count--;
                int minKey = freqs.get(minFreq).iterator().next();
                freqs.get(minFreq).remove(minKey);
                values.remove(minKey);
            }
            Node node = new Node(key, value);
            values.put(key, node);
            minFreq = 1;
            freqs.get(1).add(key);
            count++;
        }
    }
}
