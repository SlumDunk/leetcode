package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 16:20
 * @Description:
 */
public class Lintcode94 {
    class ResultType {
        int singlePath;
        int maxPath;

        ResultType(int singlePath, int maxPath) {
            //从根节点到任意点的最短路径，该路径可以不包含任何节点
            this.singlePath = singlePath;
            //从树中任意节点到任意节点的最短路径，该路径至少需要包含一个节点
            this.maxPath = maxPath;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.maxPath;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        } else {
            ResultType left = helper(root.left);
            ResultType right = helper(root.right);

            int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;

            singlePath = Math.max(singlePath, 0);

            int maxPath = Math.max(left.maxPath, right.maxPath);

            maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

            return new ResultType(singlePath, maxPath);
        }
    }
}
