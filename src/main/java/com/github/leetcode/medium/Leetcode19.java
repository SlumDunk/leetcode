package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/21/18 14:22
 * @Description: Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先计算出链的长度
        int len = 0;
        ListNode curNode = head;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        //要删除的节点的位置索引
        int index = len - n;
        int count = 0;
        curNode = head;
        if (index == 0) {//要删除的是头结点
            head = head.next;
        } else {//要删除的不是头结点
            while (count < index - 1) {//找到要删除的节点的前一个节点
                curNode = curNode.next;
                count++;
            }
            curNode.next = curNode.next.next;

        }
        return head;
    }
}
