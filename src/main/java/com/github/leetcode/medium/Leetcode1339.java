package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 * Example 3:
 * <p>
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * Example 4:
 * <p>
 * Input: root = [1,1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
 */
public class Leetcode1339 {
    long maxProduct;
    long sumAll = 0;

    public int maxProduct(TreeNode root) {
        sumAll = modify(root);
        maxProduct = 1;

        findMaxP(root);

        return (int) (maxProduct % (int) (Math.pow(10, 9) + 7));
    }

    private void findMaxP(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            long ans = (node.left.val * (sumAll - node.left.val));
            maxProduct = Math.max(maxProduct, ans);
            findMaxP(node.left);
        }

        if (node.right != null) {
            long ans = (node.right.val * (sumAll - node.right.val));
            maxProduct = Math.max(maxProduct, ans);
            findMaxP(node.right);
        }
    }

    private int modify(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = modify(node.left);
            int right = modify(node.right);
            return node.val = node.val + left + right;
        }
    }
}
