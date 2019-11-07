package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 11:07
 * @Description: Given a linked list and a frequency x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        //构造两个子链表 small链表和big链表，然后将small和big连接起来
        ListNode small = new ListNode(-1);
        ListNode smallHead = null;
        ListNode big = new ListNode(-1);
        ListNode bigHead = null;
        while (head != null) {
            if (head.val >= x) {
                if (bigHead == null) {
                    bigHead = head;
                }
                big.next = head;
                big = big.next;//指针前移
            } else {
                if (smallHead == null) {
                    smallHead = head;
                }
                small.next = head;
                small = small.next;//指针前移
            }
            head = head.next;
        }
        if (smallHead != null) {//存在小于x的
            small.next = bigHead;
            if (big != null) {
                //避免形成环路
                big.next = null;
            }
            return smallHead;
        } else {//全都大于等于x
            return bigHead;
        }
    }


    public ListNode partition__(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);


        ListNode tmp1 = head1;
        ListNode tmp2 = head2;

        while (head != null) {
            if (head.val < x) {
                tmp1.next = head;
                tmp1 = tmp1.next;
            } else {
                tmp2.next = head;
                tmp2 = tmp2.next;
            }
            head = head.next;
        }
        tmp2.next = null;
        tmp1.next = head2.next;
        return head1.next;
    }
}

