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

    public ListNode reverseBetween__(ListNode head, int m, int n) {
        //prem postn
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prem = head;
        ListNode nodeM = head.next;
        head = nodeM;
        for (int i = m; i < n; i++) {
            head = head.next;
        }
        ListNode nodeN = head;

        //postn 作为nodeM的前置节点
        ListNode prev = head.next;
        //翻转
        while (nodeM != null && m <= n) {
            ListNode tmp = nodeM.next;
            nodeM.next = prev;
            prev = nodeM;
            nodeM = tmp;
            m++;
        }

        //翻转结束，调整prem的next指针
        prem.next = nodeN;

        return dummy.next;

    }


    public ListNode reverseBetween___(ListNode head, int m, int n) {
        //prem postn
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode prem = head;
        ListNode nodeM = head.next;

        ListNode nodeN = nodeM, postN = nodeN.next;

        //走到第n个节点
        for (int i = m; i < n; i++) {
            if (postN == null) {
                return null;
            }
            ListNode tmp = postN.next;
            postN.next = nodeN;
            nodeN = postN;
            postN = tmp;
        }
        nodeM.next = postN;
        prem.next = nodeN;

        return dummy.next;

    }
}
