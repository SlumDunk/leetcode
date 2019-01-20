package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 19:47
 * @Description: Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example
 * Given 1->3->2->null, sort it to 1->2->3->null.
 * <p>
 * Challenge
 * Solve it by merge sort & quick sort separately.
 */
public class Lintcode98 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = null;
        Lintcode98 lintcode98 = new Lintcode98();
        lintcode98.sortList(head);
    }

    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        } else {
            //找中点
            ListNode mid = findMid(head);
            //拆分，排序
            ListNode right = sortList(mid.next);
            mid.next = null;
            ListNode left = sortList(head);
            //合并
            return mergeList(left, right);
        }
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.val > head2.val) {
                    currentNode.next = head2;
                    head2 = head2.next;
                } else {
                    currentNode.next = head1;
                    head1 = head1.next;
                }
            } else if (head1 != null) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }
}
