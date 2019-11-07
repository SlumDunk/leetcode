package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 21:59
 * @Description: Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: 4
 */
public class Leetcode270 {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }

    class Result {
        double diff = Double.MAX_VALUE;
        TreeNode node;

        public Result() {

        }
    }


    public int closestValue__(TreeNode root, double target) {
        Result ans = helper(root, target);
        return ans.node.val;
    }

    /**
     * 通用做法
     *
     * @param node
     * @param target
     * @return
     */
    public Result helper(TreeNode node, double target) {
        Result result = new Result();
        if (node == null) {
            return result;
        }
        if (node.val == target) {
            result.node = node;
            result.diff = 0;
            return result;
        } else {
            double local = Math.abs(node.val - target);
            Result left = helper(node.left, target);
            Result right = helper(node.right, target);

            if (local < left.diff && local < right.diff) {
                result.diff = local;
                result.node = node;
                return result;
            } else {
                return left.diff > right.diff ? right : left;
            }

        }
    }
}
