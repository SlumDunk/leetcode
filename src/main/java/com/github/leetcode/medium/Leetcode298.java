package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 10:51
 * @Description: Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * <p>
 * Output: 3
 * <p>
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * <p>
 * Output: 2
 * <p>
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */
public class Leetcode298 {
//    private int longest;

    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        int subtreeLongest = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        longest = Math.max(longest, subtreeLongest);

        return subtreeLongest;
    }


    int longest = 1;

    public int longestConsecutive_(TreeNode root) {
        //from parent to child
        if (root == null) {
            return 0;
        } else {
            helper_(root);
            return longest;
        }
    }

    public int helper_(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = helper_(node.left);
            int right = helper_(node.right);

            int len = 1;
            //
            if (left != 0 && node.left.val == node.val + 1) {
                len = Math.max(len, left + 1);


            }
            if (right != 0 && node.right.val == node.val + 1) {
                len = Math.max(len, right + 1);

            }
            longest = Math.max(longest, len);

            return len;
        }
    }

}
