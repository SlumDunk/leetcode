package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 15:35
 * @Description: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        //计算链表的长度
        int len = 0;
        ListNode curNode = head;
        while (curNode != null) {
            curNode = curNode.next;
            len++;
        }
        //真实的位移
        k = k % len;
        //将链表后k位移到链表头部即可
        int count = 0;
        curNode = head;
        //找到新链表的尾部节点
        while (count < len - k - 1) {
            curNode = curNode.next;
            count++;
        }
        //新的头结点
        ListNode newHead = curNode.next;
        //新的尾部节点下一位
        curNode.next = null;
        ////找到尾部节点
        curNode = newHead;
        if (curNode != null) {
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            //将原来的头部节点接到尾部节点后面
            curNode.next = head;
        } else {
            newHead = head;
        }
        return newHead;
    }
}
