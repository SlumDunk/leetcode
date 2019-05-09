package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 14:55
 * @Description: Given a binary tree, count the number of uni-frequency subtrees.
 * <p>
 * A Uni-frequency subtree means all nodes of the subtree have the same frequency.
 * <p>
 * Example :
 * <p>
 * Input:  root = [5,1,5,5,5,null,5]
 * <p>
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * <p>
 * Output: 4
 */
public class Leetcode250 {
    /**
     * 结果个数
     */
    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        //后序遍历
        helper(root);
        return res;
    }

    public boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }

            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }

        return false;

    }
}
