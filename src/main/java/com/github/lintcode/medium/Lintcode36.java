package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 19:06
 * @Description:
 */
public class Lintcode36 {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m:    An integer
     * @param n:    An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null) {
            return head;
        } else {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            head = dummyNode;
            ListNode prev, post;
            int index = 1;
            while (index < m) {
                head = head.next;
                index++;
            }
            prev = head;
            ListNode mNode = head.next;
            ListNode nNode = mNode;
            post = nNode.next;
            for (int i = m; i < n; i++) {
                if (post == null) {
                    return null;
                }
                ListNode temp = post.next;
                post.next = nNode;
                nNode = post;
                post = temp;
            }
            prev.next = nNode;
            mNode.next = post;
            return dummyNode.next;

        }
    }
}
