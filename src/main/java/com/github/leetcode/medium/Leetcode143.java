package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 22:44
 * @Description: Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null
                || head.next == null
                || head.next.next == null)
            return;
        //先利用快慢指针找到中间节点，然后翻转右半部分链表
        ListNode slow = head;
        ListNode fast = head;
        // 找到中间结点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //右半部分链表开始节点
        ListNode right = slow.next;
        // 第一个链表的长度大于（+1）等于第二个链表长度
        //切断成两个链表
        slow.next = null;
        // 反转后半链表
        right = reverseList(right);
        ListNode leftNext = null;
        ListNode rightNext = null;
        ListNode left = head;
        // 合并两个链表
        while (right != null) {
            //暂时保存前半链表的下一节点指针
            leftNext = left.next;
            rightNext = right.next;
            //将first的next指针指向second当前节点
            left.next = right;
            //second的下一节点指针指向原来的first的下一指针
            right.next = leftNext;
            //两部分链表同时前进
            left = leftNext;
            right = rightNext;
        }
    }

    /**
     * 就地翻转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            //暂存当前节点的下一节点
            next = head.next;
            //翻转当前下一节点指针
            head.next = prev;
            //当前节点变为下一节点的前置节点
            prev = head;
            //原有的当前节点的下一节点变成当前节点
            head = next;
        }
        return prev;
    }
}
