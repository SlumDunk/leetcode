package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Example :
 * <p>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * <p>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 * <p>
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class Leetcode783 {
    public static void main(String[] args) {

    }

    /**
     * 前置节点的值
     */
    Integer prev = null;
    /**
     * 全局结果值
     */
    Integer result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        //中序遍历记住上一个节点的值
        if (root == null || (root.left == null && root.right == null)) return 0;
        dfs(root);
        return result;
    }

    /**
     * 深度优先中序遍历树
     *
     * @param root
     */
    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        //先处理左子树
        if (root.left != null) {
            dfs(root.left);
        }
        //处理根节点
        result = prev == null ? result : Math.min(root.val - prev, result);
        prev = root.val;
        //处理右子树
        if (root.right != null) {
            dfs(root.right);
        }

    }
}
