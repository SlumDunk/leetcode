package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 * <p>
 * 2
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 * <p>
 * 2
 */
public class Leetcode487 {
    private int max = 1;

    public int longestUnivaluePath(TreeNode root) {
        findLongestPath(root);
        return max;
    }

    private int findLongestPath(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root == null) {
            return 0;
        }
        left = findLongestPath(root.left);
        right = findLongestPath(root.right);
        if (root.left != null && root.left.val == root.val) {
            left += 1;
        } else {
            left = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            right += 1;
        } else {
            right = 0;
        }

        max = Math.max(max, left + right);
        return Math.max(left, right);

    }
}
