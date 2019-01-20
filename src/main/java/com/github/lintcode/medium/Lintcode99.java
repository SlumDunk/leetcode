package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 20:20
 * @Description: Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 * <p>
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * <p>
 * Example
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * <p>
 * Challenge
 * Can you do this in-place without altering the nodes' values?
 */
public class Lintcode99 {
    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        //找中点，
        ListNode mid = findMid(head);
        //右边列表翻转
        ListNode right = reverseList(mid.next);
        //拆分
        mid.next = null;
        //合并左右链表
        mergeList(head, right);

    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;
        int index = 0;
        while (head2 != null && head1 != null) {
            if (index % 2 == 0) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
            index++;
        }

        if (head1 != null) {
            currentNode.next = head1;
        } else {
            currentNode.next = head2;
        }

        return dummyNode.next;
    }
}
