package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 20:53
 * @Description: Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 * <p>
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * <p>
 * <p>
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
public class Leetcode549 {

    private int longest;

    /**
     * The idea here is to calculate the longest path from a node.
     * Longest Path will be Math.max((increasing from left + decreasing from right), (decreasing from left+ increasing from right))
     *
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        checkNode(root);
        return longest;
    }

    private void checkNode(TreeNode root) {
        if (root == null) return;
        //左边向下递增，右边往下递减
        int pathOne = getLongest(root.left, 1, root.val, 0) + getLongest(root.right, -1, root.val, 0);
        //左边往下递减，右边向下递增
        int pathTwo = getLongest(root.right, 1, root.val, 0) + getLongest(root.left, -1, root.val, 0);
        int maxPath = Math.max(pathOne, pathTwo) + 1;
        if (maxPath > longest) longest = maxPath;
        checkNode(root.left);
        checkNode(root.right);
    }

    /**
     * @param current 当前节点
     * @param dir     方向，递增还是递减
     * @param prev    父节点值
     * @param path    长度值
     * @return
     */
    private int getLongest(TreeNode current, int dir, int prev, int path) {
        if (current == null) return path;
        if (dir == 1) {
            if (current.val >= prev && current.val - prev == 1) path++;
            else return path;
        } else {
            if (current.val <= prev && prev - current.val == 1) path++;
            else return path;
        }

        int longestPath = Math.max(getLongest(current.left, dir, current.val, path), getLongest(current.right, dir, current.val, path));
        return longestPath;
    }
}
