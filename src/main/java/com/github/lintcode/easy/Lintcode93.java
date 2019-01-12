package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 21:23
 * @Description:
 */
public class Lintcode93 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        } else {
            return getDepth(root) != -1;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
