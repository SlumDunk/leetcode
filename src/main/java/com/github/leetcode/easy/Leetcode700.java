package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to search: 2
 * You should return this subtree:
 * <p>
 * 2
 * / \
 * 1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class Leetcode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            if (root.val == val) {//等于当前节点，返回
                return root;
            } else if (root.val > val) {//小于当前节点
                return searchBST(root.left, val);
            } else {//大于当前节点
                return searchBST(root.right, val);
            }
        }
    }

    public TreeNode searchBST__(TreeNode root, int val) {
        return helper(root, val);
    }

    public TreeNode helper(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        } else {
            if (node.val > val) {
                return helper(node.left, val);
            } else {
                return helper(node.right, val);
            }
        }
    }
}
