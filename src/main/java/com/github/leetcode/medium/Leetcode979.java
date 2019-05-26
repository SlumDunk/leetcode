package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 5/24/19 19:30
 * @Description: Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 * <p>
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
 * <p>
 * Return the number of moves required to make every node have exactly one coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,2]
 * Output: 2
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,0,null,3]
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 1<= N <= 100
 * 0 <= node.val <= N
 */
public class Leetcode979 {
    public int distributeCoins(TreeNode root) {
        return dfs(root)[1];
    }

    /**
     * At each node, you're reporting up the coin differential of the subtree, and the number of moves for the subtree.
     *
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int excessCoins = root.val - 1;
        int moves = 0;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        moves += left[1];
        moves += right[1];
        excessCoins += left[0];
        excessCoins += right[0];
        moves += Math.abs(excessCoins);
        return new int[]{excessCoins, moves};
    }
}
