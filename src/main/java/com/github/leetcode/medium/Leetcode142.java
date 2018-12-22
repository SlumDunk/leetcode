package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 22:33
 * @Description: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 利用快慢指针来做
        ListNode fast = head;
        ListNode slow = head;
        //是否存在环
        Boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//在环中的某个节点发生碰撞
                flag = true;
                break;
            }
        }
        //头结点距离环开始的距离为A，环开始到碰撞的距离为B，那么快指针走过的距离为2(A+B),满指针走过的距离为A+B，2(A+B)=A+B+N,N为环的大小，碰撞节点走到开始节点的距离为A
        if (flag) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        } else {
            return null;
        }
    }

}