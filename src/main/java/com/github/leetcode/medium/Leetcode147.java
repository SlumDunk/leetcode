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
        //在有序链表中查找要插入的位置
        ListNode curNode = sortedHead;
        ListNode tmpNode = null;
        while (head != null) {
            //存储原有链表的下一节点
            tmpNode = head.next;
            //从前往后找到要插入的位置
            curNode = sortedHead;
            while (curNode.next != null && curNode.next.val < head.val) {
                curNode = curNode.next;
            }
            //找到当前节点是要插入节点的前置节点
            head.next = curNode.next;
            curNode.next = head;
            //下个要插入的节点
            head = tmpNode;
        }
        return sortedHead.next;
    }

}
