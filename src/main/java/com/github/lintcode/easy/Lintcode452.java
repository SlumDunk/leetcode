package com.github.lintcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 18:45
 * @Description:
 */
public class Lintcode452 {
    /**
     * @param head: a ListNode
     * @param val:  An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //要删除节点的前置节点
        head = dummyNode;
        while (head.next != null) {
            if (head.next.val != val) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return dummyNode.next;
    }
}
