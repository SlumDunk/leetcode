package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 10:31
 * @Description: Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        //解决删除的节点可能是头结点的情况，所以创建一个新的虚拟头结点
        ListNode newHead = new ListNode(-1);
        ListNode currentNode = newHead;
        while (head != null) {
            if (head.val == val) {//是要删除的节点，直接跳过
            } else {//不是要删除的节点，接到新链表中
                currentNode.next = head;
                currentNode = currentNode.next;
            }
            head = head.next;
        }
        //新链表结尾指向空
        currentNode.next = null;
        return newHead.next;
    }

    public ListNode removeElements__(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                pre.next = head;
                pre = head;
                head = head.next;
            }
        }
        pre.next = null;
        return dummy.next;
    }
}
