package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 13:39
 * @Description: You are given a doubly linked list which in addition to the children and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * <p>
 * <p>
 * Explanation for the above example:
 * <p>
 * Given the following multilevel doubly linked list:
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return the following flattened doubly linked list:
 */
public class Leetcode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return head;
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node temp = p.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = p.next;
            if (p.next != null) p.next.prev = temp;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }

}
