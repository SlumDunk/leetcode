package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 07:35
 * @Description: Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 10 10
 * /  \
 * 2   3
 * <p>
 * Output: True
 * Explanation:
 * 5
 * /
 * 10
 * <p>
 * Sum: 15
 * <p>
 * 10
 * /  \
 * 2    3
 * <p>
 * Sum: 15
 * Example 2:
 * Input:
 * 1
 * / \
 * 2  10
 * /  \
 * 2   20
 * <p>
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * Note:
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 <= n <= 10000
 */
public class Leetcode663 {
    public boolean checkEqualTree(TreeNode root) {
        int tot = sum(root);
        return isSplitable(root.left, tot) || isSplitable(root.right, tot);
    }

    /**
     * 求出树各个子树的和，并更新到各个祖先节点
     *
     * @param node
     * @return
     */
    public int sum(TreeNode node) {
        if (node == null) return 0;
        int res = node.val;
        res += sum(node.left);
        res += sum(node.right);
        node.val = res;
        return res;
    }

    /**
     * DFS搜索子树和等于树和一半的节点
     *
     * @param node
     * @param tot
     * @return
     */
    public boolean isSplitable(TreeNode node, int tot) {
        if (node == null) return false;
        if (node.val * 2 == tot) return true;
        return isSplitable(node.left, tot) || isSplitable(node.right, tot);
    }
}
