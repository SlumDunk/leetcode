package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 21:47
 * @Description: Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 * Example
 * An example:
 * <p>
 * 2
 * / \
 * 1   4
 * / \
 * 3   5
 * The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 */
public class Lintcode95 {
    Integer last = Integer.MIN_VALUE;
    Boolean isFirst = true;

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        } else {
            if (!isValidBST(root.left)) {
                return false;
            }
            if (!isFirst && root.val <= last) {
                return false;
            }
            last = root.val;
            isFirst = false;
            if (!isValidBST(root.right)) {
                return false;
            }
            return true;
        }
    }
}
