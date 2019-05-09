package com.github.interview.amazon;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 16:54
 * @Description:
 */
public class MaximumAverageNode {
    class ResultType {
        TreeNode node;
        int sum;
        int size;

        public ResultType(TreeNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    private ResultType result = null;

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return result.node;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, 0);
        }
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType currResult = new ResultType(root, leftResult.sum + rightResult.sum + root.val, leftResult.size + rightResult.size + 1);

        if (result == null || currResult.sum * result.size > result.sum * currResult.size) {
            result = currResult;
        }
        return currResult;
    }


}
