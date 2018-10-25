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
        ListNode middle = getMiddleOfList(head);
        ListNode next = middle.next;
        middle.next = null;//把两个链表断开分为左边（包括middle）一半和右边一半
        return mergeTwoList(sortList(head), sortList(next));

    }

    public ListNode getMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoList(ListNode headA, ListNode headB) {

        ListNode fakeNode = new ListNode(-1);
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
