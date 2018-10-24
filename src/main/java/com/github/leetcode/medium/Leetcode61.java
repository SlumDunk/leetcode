package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 15:35
 * @Description: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int cnt = 1;
        ListNode p2 = head;
        while (p2.next != null) {
            cnt++;
            p2 = p2.next;
        }
        k = k % cnt;
        ListNode pHead = head;
        ListNode p1 = head;
        for (int i = 0; i < cnt - k - 1; i++) {
            p1 = p1.next;
        }
        p2.next = pHead;
        pHead = p1.next;
        p1.next = null;
        return pHead;
    }
}
