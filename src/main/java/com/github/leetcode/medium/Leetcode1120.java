package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 16:56
 * @Description: Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 * <p>
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have and average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have and average of 6 / 1 = 6.
 * For the node with value = 1 we have and average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 5000.
 * Each node will have a value between 0 and 100000.
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */
public class Leetcode1120 {
    double max = Double.MIN_VALUE;

    /**
     * 存储子树的和以及节点的个数
     */
    class Pair {
        double sum;
        double count;

        public Pair(double sum, double count) {
            this.sum = sum;
            this.count = count;

        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0.0;
        } else {
            helper(root);
            return max;
        }
    }

    /**
     * @param root
     * @return
     */
    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0.0, 0);
        } else {
            Pair left = helper(root.left);
            Pair right = helper(root.right);
            double sum = left.sum + right.sum + root.val;
            double count = left.count + right.count + 1;
            max = Math.max(sum / count, max);
            return new Pair(sum, count);
        }
    }
}
