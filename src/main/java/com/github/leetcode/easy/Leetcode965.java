package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 16:57
 * @Description: A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: [2,2,2,5,2]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 */
public class Leetcode965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
