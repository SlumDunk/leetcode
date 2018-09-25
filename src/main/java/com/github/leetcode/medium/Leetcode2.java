package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 09:45
 * @Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Leetcode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Leetcode2 leetcode2 = new Leetcode2();
        leetcode2.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0);
        ListNode headNode = new ListNode(0);
        Queue<Integer> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int count = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                sum += queue1.poll();
            }
            if (!queue2.isEmpty()) {
                sum += queue2.poll();
            }
            //high bit
            ListNode tmpNode = new ListNode(sum / 10);
            //low bit
            curNode.val = sum % 10;
            if (count == 0) {
                headNode = curNode;
            }
            if (!queue1.isEmpty() || !queue2.isEmpty() || tmpNode.val != 0) {
                curNode.next = tmpNode;
                curNode = tmpNode;
            }
            sum /= 10;
            count++;
        }

        return headNode;
    }
}
