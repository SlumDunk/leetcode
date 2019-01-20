package com.github.lintcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 19:23
 * @Description: Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * <p>
 * Example
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 */
public class Lintcode165 {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null && l2 == null) {
            return null;
        } else {
            ListNode dummyNode = new ListNode(-1);
            ListNode currentNode = dummyNode;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    if (l1.val >= l2.val) {
                        currentNode.next = l2;
                        l2 = l2.next;
                    } else {
                        currentNode.next = l1;
                        l1 = l1.next;
                    }
                } else if (l1 != null) {
                    currentNode.next = l1;
                    l1 = l1.next;
                } else if (l2 != null) {
                    currentNode.next = l2;
                    l2 = l2.next;
                }
                currentNode = currentNode.next;
            }
            return dummyNode.next;
        }
    }
}
