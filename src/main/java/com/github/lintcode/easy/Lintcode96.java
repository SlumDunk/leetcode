package com.github.lintcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 19:29
 * @Description: Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 */
public class Lintcode96 {
    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        } else {
            ListNode LeftDummyNode = new ListNode(-1);
            ListNode rightDummyNode = new ListNode(-1);
            ListNode left = LeftDummyNode, right = rightDummyNode;
            while (head != null) {
                if (head.val < x) {
                    left.next = head;
                    left = left.next;
                } else {
                    right.next = head;
                    right = right.next;
                }
                head = head.next;
            }
            left.next = rightDummyNode.next;
            right.next = null;
            return LeftDummyNode.next;

        }

    }
}
