package com.github.lintcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 18:58
 * @Description: Reverse a linked list.
 * <p>
 * Example
 * Example1:
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * Example2:
 * For linked list 1->2->3->4, the reversed linked list is 4->3->2->1
 * <p>
 * Challenge
 * Reverse it in-place and in one-pass
 */
public class Lintcode35 {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        } else {
            ListNode prev = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }
}
