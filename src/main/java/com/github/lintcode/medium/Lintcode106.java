package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;
import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/19/19 22:10
 * @Description: Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * Example
 * 2
 * 1->2->3  =>   / \
 * 1   3
 */
public class Lintcode106 {
    ListNode current;

    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        current = head;
        int size = getListLength(head);
        return sortedListToBSTHelper(size);

    }

    public int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;
        return root;
    }
}
