package com.github.leetcode.easy;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 11:08
 * @Description: Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * <p>
 * 4 -> 5 -> 1 -> 9
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 * should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list
 * should become 4 -> 5 -> 9 after calling your function.
 * Note:
 * <p>
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        //把下一节点的值赋给当前节点，当前节点的next指向下一节点的next节点
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public void deleteNode__(ListNode node) {
        //直接改变节点的值
        while (node != null && node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                return;
            } else {
                node = node.next;
            }

        }

        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public void deleteNode___(ListNode node) {
        //直接改变节点的值
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
