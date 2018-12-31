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
        //节点值都是非负的
        //根节点是最小的,另一个与根节点值不等的节点值就是次小值
        if (root == null || root.left == null) {//不符合树条件
            return -1;
        } else {
            int val = root.val;
            int result = secondMinVal(root, val);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

    }

    /**
     * @param root 当前节点
     * @param val  目标值
     * @return
     */
    public int secondMinVal(TreeNode root, int val) {
        if (root.val != val) {
            return root.val;
        } else {//左右子节点都可能出现次大的值，去较小的值
            if (root.left != null && root.right != null) {
                return Math.min(secondMinVal(root.left, val), secondMinVal(root.right, val));
            } else {//没有子节点，无法找到次小值
                return Integer.MAX_VALUE;
            }
        }
    }
}
