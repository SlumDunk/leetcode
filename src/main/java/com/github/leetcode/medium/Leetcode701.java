package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 5/29/19 09:13
 * @Description: Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * This tree is also valid:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class Leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null) {
            prev = current;
            if (current.val < val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        current = new TreeNode(val);
        if (prev != null) {
            if (prev.val < val) {
                prev.right = current;
            } else {
                prev.left = current;
            }
        }
        return root;
    }


    public TreeNode insertIntoBST__(TreeNode root, int val) {
        helper(root, val);
        return root;
    }

    public TreeNode helper(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left != null) {
                helper(node.left, val);
            } else {
                node.left = new TreeNode(val);
            }
        } else if (node.val < val) {
            if (node.right != null) {
                helper(node.right, val);
            } else {
                node.right = new TreeNode(val);
            }
        }
        return null;
    }
}
