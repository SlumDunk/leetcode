package com.github.leetcode.medium;

import com.github.leetcode.vo.RandomListNode;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 22:14
 * @Description: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class Leetcode138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        //map存储旧节点和新节点的对应关系
        HashMap<RandomListNode, RandomListNode> newMap = new HashMap<>();
        //进行第一次遍历  将节点存入哈希表
        RandomListNode cur = head;
        while (cur != null) {
            //创建新节点
            RandomListNode newNode = new RandomListNode(cur.label);
            newMap.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        //构建新节点和新节点之间的对应关系
        while (cur != null) {
            RandomListNode node = newMap.get(cur);
            node.next = newMap.get(cur.next);
            node.random = newMap.get(cur.random);
            cur = cur.next;
        }
        return newMap.get(head);
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //先拷贝next
        copyNext(head);

        //再拷贝边
        copyRandom(head);
        //split list
        return splitList(head);

    }

    private void copyNext(Node head) {
        while (head != null) {
            Node node = new Node();
            node.random = head.random;
            node.val = head.val;
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
    }

    private void copyRandom(Node head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private Node splitList(Node head) {
        Node head2 = head.next;

        while (head != null) {
            //指向的是当前节点的copy节点
            Node tmp = head.next;
            //还原原来List的关系
            head.next = tmp.next;
            head = head.next;

            //新list的节点建立关联关系
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
        }
        return head2;
    }
}
