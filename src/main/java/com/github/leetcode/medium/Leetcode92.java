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

        //原来的链表切成三个部分，[1..m),[m,n],(n,len]
        //先计算链表的长度
        int len = 0;
        ListNode curNode = head;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        ListNode newHead = null;

        //前置链表
        ListNode prefix = new ListNode(-1);
        prefix.next = null;
        ListNode currentPrefix = prefix;
        curNode = head;
        for (int i = 1; i < m; i++) {
            currentPrefix.next = curNode;
            currentPrefix = currentPrefix.next;
            curNode = curNode.next;
        }
        newHead = prefix.next;

        //中间链表
        //借助Stack让它旋转
        Stack<ListNode> stack = new Stack<ListNode>();
        for (int i = m; i <= n; i++) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        ListNode middle = new ListNode(-1);
        middle.next = null;
        ListNode currentMiddle = middle;
        while (!stack.isEmpty()) {
            currentMiddle.next = stack.pop();
            currentMiddle = currentMiddle.next;
        }
        currentMiddle.next = null;
        if (newHead != null) {
            currentPrefix.next = middle.next;
        } else {
            newHead = middle.next;
        }
        //后置链表
        ListNode postfix = new ListNode(-1);
        postfix.next = null;
        ListNode currentPostfix = postfix;
        for (int i = n + 1; i <= len; i++) {
            currentPostfix.next = curNode;
            currentPostfix = currentPostfix.next;
            curNode = curNode.next;
        }
        currentMiddle.next = postfix.next;

        return newHead;

    }
}
