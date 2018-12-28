package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero backTrack-node. If the node has two backTrack-nodes, then this node's value is the smaller value among its two backTrack-nodes.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class Leetcode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        } else {
            int val = root.val;
            int result = minVal(root, val);
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }

    private int minVal(TreeNode root, int val) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val != val) {
            return root.val;
        } else if (root.val == val && root.left != null && root.right != null) {
            return Math.min(minVal(root.left, val), minVal(root.right, val));
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
