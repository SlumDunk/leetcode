package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 15:59
 * @Description: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 * according to the LCA definition.
 * 先遍历左子树，返回匹配的点，没有返回null。后遍历右子树，返回匹配的点，没有返回null。如果left和right都不为null，
 * 则根节点是它们的共同节点。如果left为空，则两个节点都在右子树，返回right。如果right为空，则两个节点都在左子树，返回left.
 */
public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //在当前节点的左右分支分别寻找目标节点
        if (root == null) {
            return null;
        }
        //找到p或q
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }

    }

    public TreeNode lowestCommonAncestor__(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            return helper(root, p, q);
        }
    }

    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        } else {
            if (node == p || node == q) {
                return node;
            } else {
                TreeNode left = helper(node.left, p, q);
                TreeNode right = helper(node.right, p, q);

                if (left != null && right != null) {
                    return node;
                } else {
                    return left != null ? left : right;
                }
            }
        }
    }
}
