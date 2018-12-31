package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class Leetcode563 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Leetcode563 leetcode563 = new Leetcode563();
        System.out.println(leetcode563.findTilt(root));

    }

    /**
     * 全局变量
     */
    int tilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    /**
     * 获取树的tilt
     *
     * @param root
     * @return
     */
    public int sum(TreeNode root) {
        //先处理子节点，再处理父节点
        if (root == null) {
            return 0;
        }
        //左子树的和值
        int left = sum(root.left);
        //右子树的和值
        int right = sum(root.right);
        //左右子树的差值，累加
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
