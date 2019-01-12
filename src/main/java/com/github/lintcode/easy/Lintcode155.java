package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 21:13
 * @Description: Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Example
 * Given a binary tree as follow:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * The minimum depth is 2.
 */
public class Lintcode155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        } else {
            return getMinDepth(root);
        }
    }

    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
            }
        }
    }
}
