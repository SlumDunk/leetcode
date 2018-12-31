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
public class Leetcode687 {
    /**
     * 全局变量，存储最长的路径长度
     */
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        findLongestPath(root);
        return max;
    }

    /**
     * @param root 出发节点
     * @return
     */
    private int findLongestPath(TreeNode root) {
        //左子树出发的最长路径长度
        int left = 0;
        //右子树出发的最长路径长度
        int right = 0;
        if (root == null) {
            return 0;
        }
        //递归左子树
        left = findLongestPath(root.left);
        //递归右子树
        right = findLongestPath(root.right);
        if (root.left != null && root.left.val == root.val) {
            left += 1;
        } else {
            //根节点和子节点值不同，直接切断
            left = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            right += 1;
        } else {
            //根节点和右子节点值不同，直接切断
            right = 0;
        }
        max = Math.max(max, left + right);
        //返回较长的路
        return Math.max(left, right);
    }
}
