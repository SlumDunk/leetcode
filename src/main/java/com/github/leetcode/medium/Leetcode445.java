package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 9/24/18 21:29
 * @Description: You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class Leetcode445 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0);
        Stack<Integer> stack1 = new Stack<Integer>(), stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            ListNode tmpNode = new ListNode(sum / 10);
            curNode.val = sum % 10;
            tmpNode.next = curNode;
            curNode = tmpNode;
            sum /= 10;
        }
        if (curNode.val == 0) {
            curNode = curNode.next;
        }
        return curNode;
    }


}
