package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Leetcode404 {

    //定义一个全局变量
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            getSum(root, false);
            return sum;
        }
    }

    /**
     * @param root 当且节点
     * @param add  是否加入和值
     */
    public void getSum(TreeNode root, Boolean add) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (add) {//叶子节点，且为左叶子节点
                sum += root.val;
            }
        }
        //递归左树
        getSum(root.left, true);
        //递归右树
        getSum(root.right, false);
    }
}
