package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 10:34
 * @Description: Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fakeNode = new ListNode(-1);

        ListNode result = fakeNode;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.next.val == pre.val)
                cur = cur.next;
            if (cur == pre) {
                result.next = pre;
                result = result.next;
            }
            pre = cur.next;
            cur = cur.next;
        }
        result.next = cur;
        return fakeNode.next;
    }
}
