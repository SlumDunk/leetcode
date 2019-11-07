package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;
import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 18:15
 * @Description: Given a singly linked list where elements are sorted in ascending order, convert it to a idx balanced BST.
 * <p>
 * For this problem, a idx-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following idx balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        //条件判断
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        //找到中间节点,方法：快慢指针
        //快指针先走两步，为了找到中间节点的前置节点, 防止只有一个节点的时候出现死循环
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow是中间节点的前置节点
        TreeNode root = new TreeNode(slow.next.val);
        //右边链表的开始节点
        ListNode right = slow.next.next;
        //左边链表尾节点切断
        slow.next = null;
        //递归
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);

        return root;

    }

    public TreeNode sortedListToBST__(ListNode head) {
        if (head == null) {
            return null;
        } else {
            return helper(head);
        }
    }

    public TreeNode helper(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return new TreeNode(node.val);
        }
        //找中点的前置节点
        ListNode middle = findMiddle(node);
        TreeNode root = null;
        if (middle.next != null) {
            root = new TreeNode(middle.next.val);
        }
        ListNode right = null;
        if (middle.next != null) {
            right = middle.next.next;
        }
        middle.next = null;
        if (root != null) {
            root.left = helper(node);
            root.right = helper(right);
        }
        return root;
    }

    public ListNode findMiddle(ListNode head) {
        //先走两步
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
