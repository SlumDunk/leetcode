package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 21:23
 * @Description:
 */
public class Lintcode104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = tail.next;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummyNode.next;
    }

    private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
}
