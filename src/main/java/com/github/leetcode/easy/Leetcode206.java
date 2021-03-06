package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 10:37
 * @Description: Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        //原地打转
        while (head != null) {
            //保存当前节点的下一节点
            next = head.next;
            //调整当前节点下一节点的指向
            head.next = prev;
            //当前节点变为下一节点的前置节点
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseList__(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode prev = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
            }
            return prev;
        }
    }
}
