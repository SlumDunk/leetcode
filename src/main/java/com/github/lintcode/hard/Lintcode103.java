package com.github.lintcode.hard;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 21:05
 * @Description: Given a linked list, return the node where the cycle begins.
 * <p>
 * If there is no cycle, return null.
 * <p>
 * Example
 * Given -21->10->4->5, tail connects to node index 1，return 10
 * Explanation：
 * The last node 5 points to the node whose index is 1, which is 10, so the entrance of the ring is 10
 * <p>
 * Challenge
 * Follow up:
 * <p>
 * Can you solve it without using extra space?
 */
public class Lintcode103 {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
