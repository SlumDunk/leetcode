package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 17:00
 * @Description: Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * <p>
 * Note:
 * A subtree must include all of its descendants.
 * <p>
 * Example:
 * <p>
 * Input: [10,5,15,1,8,null,7]
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * <p>
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 * The return frequency is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class Leetcode333 {

    class SearchNode {
        /**
         * 子树大小
         */
        int size;
        /**
         * 下边界
         */
        int lower;
        /**
         * 上边界
         */
        int upper;

        SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        //后序遍历
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private SearchNode helper(TreeNode root) {
        if (root == null) {
            return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        } else {
            SearchNode left = helper(root.left);
            SearchNode right = helper(root.right);
            if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
                return new SearchNode(-1, 0, 0);
            }
            int size = left.size + right.size + 1;
            res = Math.max(size, res);
            return new SearchNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
    }
}
