package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 23:53
 * @Description: Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * <p>
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation:
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 2 and 5000.
 * Each node will have value between 0 and 100000.
 */
public class Leetcode1026 {
    /**
     * 最大的绝对值差值
     */
    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return diff;
        helper(root);
        return diff;
    }

    /**
     * 返回子树中的最小值和最大值
     * dfs
     * @param node
     * @return
     */
    private int[] helper(TreeNode node) {
        int[] res = new int[]{node.val, node.val};
        if (node.left != null) {
            int[] left = helper(node.left);
            res[0] = Math.min(res[0], left[0]);
            res[1] = Math.max(res[1], left[1]);
        }
        if (node.right != null) {
            int[] right = helper(node.right);
            res[0] = Math.min(res[0], right[0]);
            res[1] = Math.max(res[1], right[1]);
        }
        diff = Math.max(diff, node.val - res[0]);
        diff = Math.max(diff, res[1] - node.val);
        return res;
    }
}
