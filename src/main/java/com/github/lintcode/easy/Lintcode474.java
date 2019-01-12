package com.github.lintcode.easy;

import com.github.lintcode.vo.ParentTreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 22:26
 * @Description: Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * <p>
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * <p>
 * The node has an extra attribute parent which point to the father of itself. The root's parent is null.
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
 */
public class Lintcode474 {
    /*
   * @param root: The root of the tree
   * @param A: node in the tree
   * @param B: node in the tree
   * @return: The lowest common ancestor of A and B
   */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        } else {
            ParentTreeNode left = lowestCommonAncestorII(root.left, A, B);
            ParentTreeNode right = lowestCommonAncestorII(root.right, A, B);
            if (left != null && right != null) {
                return root;
            } else {
                return left == null ? right : left;
            }
        }
    }
}
