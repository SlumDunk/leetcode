package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 11:07
 * @Description: Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        // 头结点
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        // 当前结点
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        // important! avoid cycle in linked list.
        // otherwise u will get TLE.
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}

