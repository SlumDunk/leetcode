package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/21/18 16:30
 * @Description: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        //重复多次，只保留一次即可，只需要暂存一个节点的信息
        if (head == null) {
            return null;
        } else {
            ListNode curNode = head;
            ListNode nextNode = head.next;
            while (nextNode != null) {
                if (curNode.val == nextNode.val) {//当前节点和下一节点的值一致
                    nextNode = nextNode.next;
                } else {//当前节点和下一节点的值不一致
                    curNode.next = nextNode;
                    curNode = nextNode;
                    nextNode = curNode.next;
                }
            }
            //将最后一个节点的下一个指针置为null
            curNode.next = null;
            return head;
        }
    }
}
