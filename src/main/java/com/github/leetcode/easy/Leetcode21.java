package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/21/18 14:24
 * @Description: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //同合并两个有序的数组一致
        ListNode head = null;
        ListNode previousNode = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        //取值小的作为新链表的头结点
        if (l1 == null) {
            head = l2;
            previousNode = head;
            l2 = l2.next;
        } else if (l2 == null) {
            head = l1;
            previousNode = head;
            l1 = l1.next;
        } else if (l1.val <= l2.val) {
            head = l1;
            previousNode = head;
            l1 = l1.next;
        } else {
            head = l2;
            previousNode = head;
            l2 = l2.next;
        }

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    previousNode.next = l1;
                    previousNode = l1;
                    l1 = l1.next;
                } else {
                    previousNode.next = l2;
                    previousNode = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                previousNode.next = l1;
                previousNode = l1;
                l1 = l1.next;
            } else {
                previousNode.next = l2;
                previousNode = l2;
                l2 = l2.next;
            }
        }
        return head;
    }
}
