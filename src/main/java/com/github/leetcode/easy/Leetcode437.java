package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * Accepted
 * 84,483
 * Submissions
 * 204,838
 */
public class Leetcode437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else {
            //分别以当前节点为出发点，左子节点为出发点，右子节点为出发点
            int res = findPath(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
            return res;
        }
    }

    /**
     * @param root   当前节点
     * @param sum    目标和值
     * @param curSum 当前和值
     * @return
     */
    public int findPath(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return 0;
        } else {
            curSum += root.val;
            return (curSum == sum ? 1 : 0) + findPath(root.left, sum, curSum) + findPath(root.right, sum, curSum);
        }
    }
}
