package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 13:53
 * @Description: Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;

        ListNode preNode = head; // pre node

        for (int i = 1; i < m; i++) {
            preNode = preNode.next;
        }


        ListNode tempNode = preNode.next;

        Stack<ListNode> stack = new Stack<>();
        int i = 0;
        while (m + i <= n) {
            stack.push(tempNode);
            tempNode = tempNode.next;
            i++;
        }

        ListNode postNode = tempNode; // post node

        ListNode resultNode = stack.pop();
        tempNode = resultNode;

        while (!stack.isEmpty()) {
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }

        preNode.next = resultNode;
        tempNode.next = postNode;

        return dummyNode.next;

    }
}
