package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 13:40
 * @Description: Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
 * <p>
 * Recall that:
 * <p>
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
 * The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Explanation:
 * The deepest leaves are the nodes with values 2 and 3.
 * The lowest common ancestor of these leaves is the node with value 1.
 * The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4]
 * Output: [4]
 * Example 3:
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given tree will have between 1 and 1000 nodes.
 * Each node of the tree will have a distinct value between 1 and 1000.
 */
public class Leetcode1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode[] res = new TreeNode[1];
        helper(root, -1, new int[]{-1}, res);
        return res[0];
    }

    /**
     * helper
     *
     * @param root      当前节点
     * @param prevDepth 前面路径深度
     * @param maxDepth  最大深度
     * @param res       结果
     * @return 返回子树的深度
     */
    private int helper(TreeNode root, int prevDepth, int[] maxDepth, TreeNode[] res) {
        if (root == null) {
            return -1;
        }

        int curDepth = prevDepth + 1;
        // 走到叶子节点
        if (root.left == null && root.right == null) {
            if (curDepth > maxDepth[0]) {
                maxDepth[0] = curDepth;
                res[0] = root;
            }
            return curDepth;
        }

        // common situation, get depth from both children
        int leftDepth = helper(root.left, curDepth, maxDepth, res);
        int rightDepth = helper(root.right, curDepth, maxDepth, res);

        // 左右子节点的深度都等于最大深度，更新结果集 非叶子节点
        if (leftDepth == maxDepth[0] && rightDepth == maxDepth[0]) {
            res[0] = root;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
