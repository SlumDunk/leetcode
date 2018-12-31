package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 16:51
 * @Description: Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //调换当前节点两个子节点
        TreeNode temp = null;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        //对左右子树进行递归操作
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
