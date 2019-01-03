package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class Leetcode530 {
    public static void main(String[] args) {

    }

    /**
     * 前置节点的值
     */
    Integer prev = null;
    /**
     * 全局结果值
     */
    Integer result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        //中序遍历记住上一个节点的值
        if (root == null || (root.left == null && root.right == null)) return 0;
        dfs(root);
        return result;
    }

    /**
     * 深度优先中序遍历树
     *
     * @param root
     */
    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        //先处理左子树
        if (root.left != null) {
            dfs(root.left);
        }
        //处理根节点
        result = prev == null ? result : Math.min(root.val - prev, result);
        prev = root.val;
        //处理右子树
        if (root.right != null) {
            dfs(root.right);
        }

    }
}
