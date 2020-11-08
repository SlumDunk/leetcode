package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Leetcode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        //求出树的高度，经过根节点的最长路径和不经过节点的最长路径，取最大值
        if (root == null) {
            return 0;
        } else {
            int leftHeight = 0, rightHeight = 0, leftPart = 0, rightPart = 0;
            if (root.left != null) {
                //获取左树的高度
                leftHeight = getHeight(root.left);
                leftPart = diameterOfBinaryTree(root.left);
            }
            if (root.right != null) {
                //获取右子树的高度
                rightHeight = getHeight(root.right);
                rightPart = diameterOfBinaryTree(root.right);
            }
            return Math.max(Math.max(leftPart, rightPart), leftHeight + rightHeight);
        }
    }

    /**
     * 获取树的高度
     *
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    class Pair {
        /**
         * 代表节点高度
         */
        int singlePath;
        int path;

        public Pair(int singlePath, int path) {
            this.singlePath = singlePath;
            this.path = path;
        }
    }

    int max = 0;

    public int diameterOfBinaryTree_(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            helper(root);
            return max;
        }
    }

    public Pair helper(TreeNode node) {
        if (node == null) {
            return new Pair(-1, Integer.MIN_VALUE);
        }

        Pair left = helper(node.left);
        Pair right = helper(node.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + 1;

        int path = left.singlePath + right.singlePath + 2;

        max = Math.max(max, path);

        return new Pair(singlePath, path);

    }
}
