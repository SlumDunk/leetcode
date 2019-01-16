package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 08:27
 * @Description: The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Lintcode535 {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        } else {
            int[] result = rob(root);
            return Math.max(result[0], result[1]);
        }
    }

    public int[] rob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = rob(node.left);
        int[] right = rob(node.right);
        int[] ans = new int[2];
        //不抢这个点
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //抢这个点
        ans[1] = left[0] + right[0] + node.val;
        return ans;
    }
}
