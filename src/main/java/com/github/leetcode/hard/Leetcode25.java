package com.github.leetcode.hard;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 09:26
 * @Description: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        } else {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            head = dummy;
            while (head.next != null) {
                head = reverseNextK(head, k);
            }

            return dummy.next;
        }
    }

    private ListNode reverseNextK(ListNode head, int k) {
        ListNode next = head;
        //check there is enough nodes to reverse
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }

        ListNode nextHead = head.next;
        ListNode prev = head, curt = nextHead;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        nextHead.next = curt;
        head.next = prev;
        return nextHead;


    }
}
