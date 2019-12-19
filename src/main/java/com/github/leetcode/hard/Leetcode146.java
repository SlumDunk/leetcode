package com.github.leetcode.hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 10:41
 * @Description: Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class Leetcode146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);
        cache.put(1, 1);
        cache.put(4, 1);
        cache.get(2);
    }

    static class LRUCache {

        /**
         * 用于构造双向链表
         */
        class Node {
            int key;
            int value;
            Node next;
            Node pre;

            public Node() {

            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, Node> map;
        /**
         * 剩余容量
         */
        private int capacity;
        /**
         * 双向链表头结点 最近操作的节点放在头部
         */
        private Node head;
        /**
         * 双向链表尾节点
         */
        private Node tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                //没找到
                return -1;
            } else {
                //调整位置
                head(node);
                return node.value;
            }
        }

        /**
         * 插入链表的头部
         *
         * @param node
         */
        private void head(Node node) {
            remove(node);
            add(node);
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {//调整node的位置,插入头部
                node.value = value;
                head(node);
                map.put(key, node);
            } else {
                Node newNode = new Node(key, value);
                //没容量了，得移除
                if (capacity == 0) {
                    Node temp = pop();
                    map.remove(temp.key);
                    capacity++;
                }
                //空链表
                add(newNode);
                map.put(key, newNode);
                capacity--;
            }
        }

        /**
         * 移除链表尾部元素
         *
         * @return
         */
        private Node pop() {
            Node node = tail.pre;
            remove(node);
            return node;
        }

        /**
         * 往链表头部添加新节点
         *
         * @param newNode
         */
        private void add(Node newNode) {
            newNode.pre = head;
            newNode.next = head.next;

            head.next.pre = newNode;
            head.next = newNode;
        }

        /**
         * 移除某个元素元素
         *
         * @return
         */
        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    class LRUCache_ {
        Deque<Node> dequeue = new LinkedList<Node>();
        int capacity;
        Map<Integer, Node> map = new HashMap<>();

        public LRUCache_(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                addNode(map.get(key));
                return map.get(key).val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                dequeue.remove(map.get(key));
            }
            map.put(key, new Node(key, value));
            addNode(map.get(key));
        }

        public void addNode(Node node) {
            if (dequeue.contains(node)) {
                dequeue.remove(node);
            }
            //超过容量 把最老的节点出队，并从map中移除
            while (dequeue.size() >= capacity) {
                Node temp = dequeue.pollFirst();
                map.remove(temp.key);
            }
            dequeue.offerLast(node);
        }

        /**
         * 数据节点
         */
        class Node {
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public boolean equals(Node obj) {
                super.equals(obj);
                return key == obj.key && val == obj.val;
            }
        }
    }
}
