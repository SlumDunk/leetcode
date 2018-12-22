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
        //从低位加到高位,注意进位
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        //将l1的位入队
        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        //将l2的位入队
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }

        //头节点
        ListNode headNode = null;
        ListNode previousNode = null;
        //进位
        int tmp = 0;
        //队列1当前数字
        int tmp1 = 0;
        //队列2当前数字
        int tmp2 = 0;
        //当前节点
        ListNode curNode = null;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                tmp1 = queue1.poll();
            }
            if (!queue2.isEmpty()) {
                tmp2 = queue2.poll();
            }
            curNode = new ListNode((tmp1 + tmp2 + tmp) % 10);
            if (headNode == null) {
                headNode = curNode;
                previousNode = curNode;
            } else {
                previousNode.next = curNode;
                previousNode=curNode;
            }
            //进位
            tmp = (tmp1 + tmp2 + tmp) / 10;
            //将tmp1和tmp2复位
            tmp1 = 0;
            tmp2 = 0;
        }
        if (tmp != 0) {
            curNode = new ListNode(tmp);
            if (headNode == null) {
                headNode = curNode;
            } else {
                previousNode.next = curNode;
            }
        }
        return headNode;
    }
}
