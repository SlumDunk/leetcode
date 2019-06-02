package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 5/11/19 15:29
 * @Description: Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(idx of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class Leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null && root.left == null) {
                root = null;
            } else if (root.right != null) {
                TreeNode pre = findDeleteReplaceRight(root);
                root.val = pre.val;
                root.right = deleteNode(root.right, pre.val);
            } else {
                TreeNode pre = findDeleteReplaceLeft(root);
                root.val = pre.val;
                root.left = deleteNode(root.left, pre.val);
            }
        }

        return root;
    }

    private TreeNode findDeleteReplaceLeft(TreeNode root) {
        TreeNode left = root.left;
        while (left.right != null) {
            left = left.right;
        }
        return left;
    }

    private TreeNode findDeleteReplaceRight(TreeNode root) {
        TreeNode right = root.right;
        while (right.left != null) {
            right = right.left;
        }

        return right;
    }
}
