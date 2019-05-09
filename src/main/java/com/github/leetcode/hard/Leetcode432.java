package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 13:58
 * @Description: Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class Leetcode432 {
    class Node {
        String key;
        int value;
        Node prev;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * hashmap + 双向链表
     */
    class AllOne {
        private Map<String, Node> map;
        private Node head;
        private Node tail;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map = new HashMap<>();
            head = new Node("", Integer.MIN_VALUE);
            tail = new Node("", Integer.MAX_VALUE);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                Node n = new Node(key, 1);
                map.put(key, n);
                link(head, n);
            } else {
                node.value = node.value + 1;
                moveBack(node);
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            Node node = map.get(key);
            if (node == null) return;
            if (node.value == 1) {
                map.remove(key);
                unlink(node);
            } else {
                node.value = node.value - 1;
                moveFront(node);
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (map.isEmpty()) return "";
            return tail.prev.key;
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (map.isEmpty()) return "";
            return head.next.key;
        }

        private void moveFront(Node node) {
            Node prev = node.prev;
            unlink(node);
            while (node.value < prev.value) {
                prev = prev.prev;
            }

            link(prev, node);
        }

        private void moveBack(Node node) {
            Node next = node.next;
            unlink(node);
            while (node.value > next.value) {
                next = next.next;
            }
            link(next.prev, node);
        }

        private void unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void link(Node prev, Node node) {
            Node next = prev.next;
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
        }

    }

    public class AllOneBucket {
        // maintain a doubly linked list of Buckets
        private Bucket head;
        private Bucket tail;
        // for accessing a specific Bucket among the Bucket list in O(1) time
        private Map<Integer, Bucket> countBucketMap;
        // keep track of count of keys
        private Map<String, Integer> keyCountMap;

        // each Bucket contains all the keys with the same count
        private class Bucket {
            int count;
            Set<String> keySet;
            Bucket next;
            Bucket pre;

            public Bucket(int cnt) {
                count = cnt;
                keySet = new HashSet<>();
            }
        }

        /**
         * Initialize your data structure here.
         */
        public AllOneBucket() {
            head = new Bucket(Integer.MIN_VALUE);
            tail = new Bucket(Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            countBucketMap = new HashMap<>();
            keyCountMap = new HashMap<>();
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (keyCountMap.containsKey(key)) {
                changeKey(key, 1);
            } else {
                keyCountMap.put(key, 1);
                if (head.next.count != 1)
                    addBucketAfter(new Bucket(1), head);
                head.next.keySet.add(key);
                countBucketMap.put(1, head.next);
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            if (keyCountMap.containsKey(key)) {
                int count = keyCountMap.get(key);
                if (count == 1) {
                    keyCountMap.remove(key);
                    removeKeyFromBucket(countBucketMap.get(count), key);
                } else {
                    changeKey(key, -1);
                }
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            return tail.pre == head ? "" : (String) tail.pre.keySet.iterator().next();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
        }

        /**
         * helper function to make change on given key according to offset
         *
         * @param key
         * @param offset
         */
        private void changeKey(String key, int offset) {
            int count = keyCountMap.get(key);
            keyCountMap.put(key, count + offset);
            Bucket curBucket = countBucketMap.get(count);
            Bucket newBucket;
            if (countBucketMap.containsKey(count + offset)) {
                // target Bucket already exists
                newBucket = countBucketMap.get(count + offset);
            } else {
                // add new Bucket
                newBucket = new Bucket(count + offset);
                countBucketMap.put(count + offset, newBucket);
                addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.pre);
            }
            newBucket.keySet.add(key);
            removeKeyFromBucket(curBucket, key);
        }

        /**
         * 从某个bucket中移除某个key
         *
         * @param bucket
         * @param key
         */
        private void removeKeyFromBucket(Bucket bucket, String key) {
            bucket.keySet.remove(key);
            if (bucket.keySet.size() == 0) {
                removeBucketFromList(bucket);
                countBucketMap.remove(bucket.count);
            }
        }

        /**
         * 移除bucket
         *
         * @param bucket
         */
        private void removeBucketFromList(Bucket bucket) {
            bucket.pre.next = bucket.next;
            bucket.next.pre = bucket.pre;
            bucket.next = null;
            bucket.pre = null;
        }

        /**
         * add newBucket after preBucket
         *
         * @param newBucket
         * @param preBucket
         */
        private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
            newBucket.pre = preBucket;
            newBucket.next = preBucket.next;
            preBucket.next.pre = newBucket;
            preBucket.next = newBucket;
        }
    }
}
