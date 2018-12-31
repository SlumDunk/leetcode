package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 10:32
 * @Description: Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 * return its depth = 3.
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //递归，左右最大层级+1
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
