package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 21:02
 * @Description: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Example
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * Notice
 * A leaf is a node with no children.
 */
public class Lintcode1353 {
    int sum = 0;

    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    public int sumNumbers(TreeNode root) {
        // write your code here
        int temp = 0;
        dfs(root, temp);
        return sum;
    }

    public void dfs(TreeNode root, int temp) {
        if (root == null) {
            return;
        } else {
            temp = temp * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += temp;
            }
            if (root.left != null) {
                dfs(root.left, temp);
            }
            if (root.right != null) {
                dfs(root.right, temp);
            }
        }
    }
}
