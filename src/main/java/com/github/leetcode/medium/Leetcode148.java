package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:17
 * @Description: Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)//递归出口  当只有一个节点时就不再递归
            return head;
        //利用快慢指针找到中间节点
        ListNode middle = getMiddleOfList(head);
        //右半链表开始节点
        ListNode right = middle.next;
        //将原有链表切成左右两个链表
        middle.next = null;
        //归并
        return mergeTwoList(sortList(head), sortList(right));

    }

    /**
     * 利用快慢指针找到中间点
     *
     * @param head
     * @return
     */
    public ListNode getMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序的链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode mergeTwoList(ListNode headA, ListNode headB) {
        //合并后链表的虚拟头结点
        ListNode fakeNode = new ListNode(-1);
        //保存新链表的当前节点
        ListNode cur = fakeNode;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                cur.next = headA;
                headA = headA.next;
            } else {
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;

        }
        cur.next = headA == null ? headB : headA;
        return fakeNode.next;
    }
}
