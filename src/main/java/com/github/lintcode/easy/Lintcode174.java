package com.github.lintcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 20:42
 * @Description: Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * Example
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * <p>
 * Challenge
 * Can you do it without getting the length of the linked list?
 * <p>
 * Notice
 * The minimum number of nodes in list is n.
 */
public class Lintcode174 {
    /**
     * @param head: The first node of linked list.
     * @param n:    An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (n <= 0) {
            return null;
        } else {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            for (int i = 0; i < n; i++) {
                if (head == null) {
                    return null;
                }
                head = head.next;
            }
            while (head != null) {
                head = head.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return dummyNode.next;
        }
    }
}
