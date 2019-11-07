package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 10:34
 * @Description: Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //表明当前是否重复
        Boolean flag = false;
        //头结点可能出现重复，所以创建个虚拟头结点
        ListNode fakeHead = new ListNode(-1);
        //新链表的前置节点节点
        ListNode newCurNode = fakeHead;
        //从前往后遍历
        ListNode curNode = head;
        ListNode nextNode = curNode.next;
        while (curNode != null) {
            if (nextNode != null) {
                if (curNode.val == nextNode.val) {//当前节点和下一节点的值重复
                    nextNode = nextNode.next;//下一节点前进
                    flag = true;
                } else {
                    if (flag) {//前面两个已经出现重复了，curNode不会加进新链表
                        curNode = nextNode;
                        nextNode = nextNode.next;
                        flag = false;
                    } else {//前面两个未出现重复，curNode会加进新链表
                        newCurNode.next = curNode;
                        newCurNode = newCurNode.next;
                        curNode = nextNode;
                        nextNode = nextNode.next;
                    }
                }
            } else {
                if (flag) {//末尾之前是重复的
                    newCurNode.next = null;
                    curNode = null;
                } else {//末尾之前不重复，加入新链表
                    newCurNode.next = curNode;
                    curNode = nextNode;
                }
            }
        }
        return fakeHead.next;

    }


    public ListNode deleteDuplicates__(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode dummyNode = new ListNode(1);
            dummyNode.next = head;
            head = dummyNode;
            while (head.next != null && head.next.next != null) {
                if (head.next.val == head.next.next.val) {
                    int val = head.next.val;
                    while (head.next != null && head.next.val == val) {
                        head.next = head.next.next;
                    }
                } else {
                    head = head.next;
                }
            }

            return dummyNode.next;
        }
    }
}
