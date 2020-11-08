package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/6/20 16:05
 * @Description: Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 5000 nodes.
 * -10^9 <= target, node.val <= 10^9
 */
public class Leetcode1214 {

    /**
     * O(2^(m+n)
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return helper(root1, root2, target);
    }

    public boolean helper(TreeNode node1, TreeNode node2, int target) {
        if (node1 == null || node2 == null) {
            return false;
        } else {
            int sum = node1.val + node2.val;
            if (sum == target) {
                return true;
            } else {
                if (sum < target) {
                    return helper(node1.right, node2, target) || helper(node1, node2.right, target);
                } else {
                    return helper(node1.left, node2, target) || helper(node1, node2.left, target);
                }
            }
        }
    }
}
