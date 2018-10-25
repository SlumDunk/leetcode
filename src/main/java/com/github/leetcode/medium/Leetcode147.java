package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:08
 * @Description: Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
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
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead = new ListNode(-1);
        while (head != null) {
            //保存head位置
            ListNode temp = head.next;
            ListNode cur = sortedHead;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            //插入
            head.next = cur.next;
            cur.next = head;
            //恢复head
            head = temp;
        }
        return sortedHead.next;
    }

}
