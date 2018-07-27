package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 *
 */
public class Leetcode437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    private int findPath(TreeNode root, int curSum, int sum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        return (curSum == sum ? 1 : 0) + findPath(root.left, curSum, sum) + findPath(root.right, curSum, sum);
    }
}
