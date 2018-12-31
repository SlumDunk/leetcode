package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 14:56
 * @Description: Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null) {//没有左分支
                return minDepth(root.right) + 1;
            } else if (root.right == null) {//没有右分支
                return minDepth(root.left) + 1;
            } else {//有左右子分支
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            }
        }
    }
}
