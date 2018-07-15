package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Leetcode404 {
    public static void main(String[] args) {

    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            getSum(root, Boolean.FALSE);
            return sum;
        }
    }

    private void getSum(TreeNode root, Boolean add) {
        if (root != null) {
            if (add && root.left == null && root.right == null) {
                sum += root.val;
            }
            getSum(root.left, Boolean.TRUE);
            getSum(root.right, Boolean.FALSE);
        }
    }
}
