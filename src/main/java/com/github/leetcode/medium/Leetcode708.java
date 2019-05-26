package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/13/19 10:53
 * @Description: Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
 * <p>
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.
 * <p>
 * If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.
 * <p>
 * The following example may help you understand the problem better:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
 */
public class Leetcode708 {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node pre = head;
        Node next = head.next;
        while (next != head) {
            if ((insertVal < next.val && pre.val <= insertVal)//e.g [1 -> 3] with val=1 or 2      (same as pre OR between pre and next)
                    || (pre.val <= insertVal && pre.val > next.val)// e.g [3 -> 1] with val=3 or higher (same as pre OR higher than pre)
                    || (pre.val > next.val && insertVal <= next.val)) {// e.g [3 -> 1] with val=1 or lower  (same as next OR lower than next)
                break;
            }
            pre = next;
            next = next.next;
        }
        pre.next = node;
        node.next = next;
        return head;
    }
}
