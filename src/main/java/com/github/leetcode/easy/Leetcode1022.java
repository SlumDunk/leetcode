package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 21:25
 * @Description: Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class Leetcode1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    /**
     * @param root
     * @param prev
     * @return
     */
    private int dfs(TreeNode root, int prev) {
        int a = 0;
        if (root == null) {
            return prev;
        }
        if (root.left != null && root.right != null) {
            a = dfs(root.left, prev * 2 + root.val) + dfs(root.right, prev * 2 + root.val);
        } else if (root.right != null) {
            a = dfs(root.right, prev * 2 + root.val);
        } else {
            a = dfs(root.left, prev * 2 + root.val);
        }
        return a;
    }
}
