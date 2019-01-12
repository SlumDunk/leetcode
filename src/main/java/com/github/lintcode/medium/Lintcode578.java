package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 12:22
 * @Description:
 */
public class Lintcode578 {
    class Result {
        boolean aExists = false;
        boolean bExists = false;
        TreeNode node;

        public Result(boolean a, boolean b, TreeNode node) {
            this.aExists = a;
            this.bExists = b;
            this.node = node;
        }
    }

    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        } else {
            Result result = dfs(root, A, B);
            if (result.aExists && result.bExists) {
                return result.node;
            } else {
                return null;
            }
        }
    }

    public Result dfs(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new Result(false, false, null);
        }

        Result leftResult = dfs(root.left, A, B);
        Result rightResult = dfs(root.right, A, B);

        boolean aExists = leftResult.aExists || rightResult.aExists || root == A;
        boolean bExists = leftResult.bExists || rightResult.bExists || root == B;

        if (root == A || root == B) {
            return new Result(aExists, bExists, root);
        } else {
            if (leftResult.node != null && rightResult.node != null) {
                return new Result(aExists, bExists, root);
            } else if (leftResult.node != null) {
                return new Result(aExists, bExists, leftResult.node);
            } else if (rightResult.node != null) {
                return new Result(aExists, bExists, rightResult.node);
            } else {
                return new Result(aExists, bExists, null);
            }
        }
    }
}
