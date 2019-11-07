package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 15:05
 * @Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, root.val);
    }

    /**
     * @param root
     * @param sum     目标和值
     * @param current 当前和值
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum, int current) {
        //目标和值和当前和值相等，而且当前节点是叶子节点
        if (sum == current && root.left == null && root.right == null) {
            return true;
        } else {
            if (root.left == null && root.right != null) {
                return hasPathSum(root.right, sum, current + root.right.val);
            } else if (root.left != null && root.right == null) {
                return hasPathSum(root.left, sum, current + root.left.val);
            } else if (root.left != null && root.right != null) {
                return hasPathSum(root.right, sum, current + root.right.val) || hasPathSum(root.left, sum, current + root.left.val);
            } else {
                return false;
            }
        }
    }

    public boolean hasPathSum__(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return helper(root, sum);
        }
    }

    public boolean helper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (sum == node.val) {
            if (node.left == null && node.right == null) {
                return true;
            }
        }

        return helper(node.left, sum - node.val) || helper(node.right, sum - node.val);
    }
}
