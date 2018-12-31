package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 14:39
 * @Description: Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class Leetcode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //求出左右子树的深度
        int depthLeft = getDepth(root.left) + 1;
        int depthRight = getDepth(root.right) + 1;
        if (Math.abs(depthLeft - depthRight) > 1) {//两个子树的高度差大于1
            return false;
        } else {//检查左右子树是否平衡
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 获取子树高度
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
    }
}
