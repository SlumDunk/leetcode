package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 15:25
 * @Description: Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class Leetcode513 {
    /**
     * 保存全局的最大深度
     */
    int maxDepth = -1;
    /**
     * 最大深度对应的值
     */
    int maxVal = -1;

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 0);
    }

    /**
     * 先根遍历
     *
     * @param root  根节点
     * @param depth 当前深度
     * @return
     */
    public int findBottomLeftValue(TreeNode root, int depth) {
        //走到叶子节点
        if (root != null && root.left == null && root.right == null) {

            if (depth > maxDepth) {
                maxDepth = depth;
                maxVal = root.val;
            }

        }

        if (root == null) return maxVal;

        findBottomLeftValue(root.left, depth + 1);
        findBottomLeftValue(root.right, depth + 1);

        return maxVal;
    }
}
