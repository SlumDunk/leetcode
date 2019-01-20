package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 20:46
 * @Description: Given a linked list, determine if it has a cycle in it.
 * <p>
 * <p>
 * <p>
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 * <p>
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Lintcode102 {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return false;
        } else {
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }
}
