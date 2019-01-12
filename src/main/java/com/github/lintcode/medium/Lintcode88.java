package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 22:19
 * @Description: Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * <p>
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * <p>
 * Example
 * For the following binary tree:
 * <p>
 * 4
 * / \
 * 3   7
 * / \
 * 5   6
 * LCA(3, 5) = 4
 * <p>
 * LCA(5, 6) = 7
 * <p>
 * LCA(6, 7) = 7
 * <p>
 * Notice
 * Assume two nodes are exist in tree.
 */
public class Lintcode88 {
    /*
   * @param root: The root of the binary search tree.
   * @param A: A TreeNode in a Binary.
   * @param B: A TreeNode in a Binary.
   * @return: Return the least common ancestor(LCA) of the two nodes.
   */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == A || root == B || root == null) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, A, B);
            TreeNode right = lowestCommonAncestor(root.right, A, B);
            if (left != null && right != null) {
                return root;
            } else {
                return left == null ? right : left;
            }
        }
    }
}
