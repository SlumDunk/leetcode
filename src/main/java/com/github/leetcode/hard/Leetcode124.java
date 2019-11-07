package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 20:20
 * @Description: Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class Leetcode124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //left+root,right+root,root,left+right+root
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //先处理子节点
            int left = dfs(root.left);
            int right = dfs(root.right);
            //left+root,right+root,left+right+root,root
            int currentSum = Math.max(0, left) + Math.max(0, right) + root.val;
            max = Math.max(max, currentSum);
            return Math.max(Math.max(left, right), 0) + root.val;
        }
    }



    class Result {
        int singlePathSum;
        int pathSum;

        public Result() {

        }

        public Result(int singlePathSum, int pathSum) {
            this.singlePathSum = singlePathSum;
            this.pathSum = pathSum;
        }
    }

    public int maxPathSum__(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            helper(root);
            return max;
        }
    }

    public Result helper(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, 0);
        } else {
            Result left = helper(node.left);
            Result right = helper(node.right);

            Result result = new Result();
            result.singlePathSum = Math.max(Math.max(left.singlePathSum, 0), Math.max(right.singlePathSum, 0)) + node.val;

            result.pathSum = Math.max(left.singlePathSum, 0) + Math.max(right.singlePathSum, 0) + node.val;
            max = Math.max(max, result.pathSum);

            return result;
        }
    }
}
