package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 14:10
 * @Description: Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 * <p>
 * Example
 * Given binary search tree:
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * Remove 3, you can either return:
 * <p>
 * 5
 * / \
 * 2   6
 * \
 * 4
 * or
 * <p>
 * 5
 * / \
 * 4   6
 * /
 * 2
 * <p>
 * {}
 * 10
 */
public class Lintcode87 {
    /*
    * @param root: The root of the binary search tree.
    * @param value: Remove the node with given value.
    * @return: The root of the binary search tree after removal.
    */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        } else {
            TreeNode dummy = new TreeNode(0);
            dummy.left = root;
            TreeNode node;
            TreeNode parent = findNode(dummy, root, value);
            if (parent.left != null && parent.left.val == value) {
                node = parent.left;
            } else if (parent.right != null && parent.right.val == value) {
                node = parent.right;
            } else {
                return dummy.left;
            }
            deleteNode(parent, node);
            return dummy.left;
        }
    }

    public TreeNode findNode(TreeNode parent, TreeNode root, int value) {
        if (root == null) {
            return parent;
        }
        if (root.val == value) {
            return parent;
        }
        if (value < root.val) {
            return findNode(root, root.left, value);
        } else {
            return findNode(root, root.right, value);
        }
    }

    public void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;

            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }

            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }

            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
