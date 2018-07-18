package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Leetcode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPart = 0, rightPart = 0, leftHeight = 0, rightHeight = 0;
        if (root.left != null) {
            leftPart = diameterOfBinaryTree(root.left);
            leftHeight = getMaxHeight(root.left);
        }
        if (root.right != null) {
            rightPart = diameterOfBinaryTree(root.right);
            rightHeight = getMaxHeight(root.right);
        }
        return Math.max(Math.max(leftPart, rightPart), leftHeight + rightHeight);
    }

    private int getMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftHeight = 0, maxRightHeight = 0;
        if (root.left != null) {
            maxLeftHeight = getMaxHeight(root.left);
        }
        if (root.right != null) {
            maxRightHeight = getMaxHeight(root.right);
        }
        return Math.max(maxLeftHeight, maxRightHeight) + 1;
    }
}
