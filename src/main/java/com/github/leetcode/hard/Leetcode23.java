package com.github.leetcode.hard;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 14:53
 * @Description: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //归并排序
        int len = lists.length;
        merge(lists, 0, len - 1);
        return null;
    }

    /**
     * @param lists
     * @param left
     * @param right
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftHead = merge(lists, left, mid);
        ListNode rightHead = merge(lists, mid + 1, right);
        return mergeList(leftHead, rightHead);
    }

    /**
     * 归并两个list
     *
     * @param leftHead
     * @param rightHead
     * @return
     */
    private ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curNode = dummyHead;
        while (leftHead != null || rightHead != null) {
            if (leftHead != null && rightHead != null) {
                if (leftHead.val <= rightHead.val) {
                    curNode.next = leftHead;
                    leftHead = leftHead.next;
                } else {
                    curNode.next = rightHead;
                    rightHead = rightHead.next;
                }
            } else if (leftHead != null) {
                curNode.next = leftHead;
                leftHead = leftHead.next;
            } else {
                curNode.next = rightHead;
                rightHead = rightHead.next;
            }
            curNode = curNode.next;
        }
        return dummyHead.next;
    }
}
