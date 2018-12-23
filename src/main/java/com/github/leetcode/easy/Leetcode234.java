package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 10:42
 * @Description: Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 */
public class Leetcode234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Leetcode234 leetcode234 = new Leetcode234();
        leetcode234.isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        //判断是否是回文链表 先利用快慢指针找到中间节点
        //然后翻转后半部分链表
        //然后比较前后链表是否相等
        ListNode fast = head;
        ListNode slow = head;
        //只有一个节点
        if (fast == null || fast.next == null) {
            return true;
        }

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //右半部分链表的头结点
        ListNode right = slow.next;
        //切断左右链表
        slow.next = null;
        //就地打转右半部分链表
        ListNode prev = null;
        ListNode next = null;
        while (right != null) {
            next = right.next;
            right.next = prev;
            prev = right;
            right = next;
        }
        //prev成了右半部分新链表的头结点
        //比较左右部分链表
        while (head != null && prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}
