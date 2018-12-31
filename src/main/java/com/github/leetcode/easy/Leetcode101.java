package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 09:28
 * @Description: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    /**
     * 判断是否对称
     *
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {//都为空，返回true
            return true;
        } else if (left == null || right == null) {//其中一个分支为空
            return false;
        } else if (left.val != right.val) {//值不同，返回false
            return false;
        } else {
            //判断子结构是否对称
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
