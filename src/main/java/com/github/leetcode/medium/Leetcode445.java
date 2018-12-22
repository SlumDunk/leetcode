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
        //利用堆栈，先将两个链表的值放进栈里头，再弹出相加
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        //低位加到高位
        ListNode next = null;
        //进位
        Integer add = 0;
        Integer sum = 0;
        Integer factor1 = 0;
        Integer factor2 = 0;
        ListNode currentNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                factor1 = stack1.pop();
                factor2 = stack2.pop();
                sum = factor1 + factor2 + add;
            } else if (!stack1.isEmpty()) {
                factor1 = stack1.pop();
                sum = factor1 + add;
            } else {
                factor2 = stack2.pop();
                sum = factor2 + add;
            }
            currentNode = new ListNode(sum % 10);
            currentNode.next = next;
            next = currentNode;
            add = sum / 10;
            sum = 0;
        }
        if (add > 0) {//还有进位
            currentNode = new ListNode(add);
            currentNode.next = next;
        }
        return currentNode;
    }


}
