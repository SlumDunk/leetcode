package com.github.interview.amazon;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 12:46
 * @Description:
 */
public class DistanceBetweenNodesInBST {
    public int bstDistance(int[] nums, int node1, int node2) {
        TreeNode root = buildBST(nums, node1, node2);
        if (root == null) return -1;
        TreeNode lca = lca(root, node1, node2);
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    /**
     * 返回距离
     *
     * @param src
     * @param dest
     * @return
     */
    private int getDistance(TreeNode src, int dest) {
        if (src.val == dest) return 0;
        TreeNode node = src.left;
        if (src.val < dest) {
            node = src.right;
        }
        return 1 + getDistance(node, dest);
    }

    /**
     * 最小公共祖先
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    private TreeNode lca(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    /**
     * 构造二叉搜索树
     *
     * @param nums
     * @param node1
     * @param node2
     * @return
     */
    private TreeNode buildBST(int[] nums, int node1, int node2) {
        TreeNode root = null;
        boolean found1 = false;
        boolean found2 = false;
        for (int val : nums) {
            if (val == node1) found1 = true;
            if (val == node2) found2 = true;

            TreeNode node = new TreeNode(val);
            if (root == null) {
                root = node;
                continue;
            }
            addToBST(root, node);
        }
        if (!found1 || !found2) return null;
        return root;
    }

    /**
     * 往树里头添加新的结点
     *
     * @param root
     * @param node
     */
    private void addToBST(TreeNode root, TreeNode node) {
        for (TreeNode curr = root; true; ) {
            if (curr.val > node.val) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
    }
}
