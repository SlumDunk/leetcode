package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 13:53
 * @Description: Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
 * <p>
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 * <p>
 * 2             2
 * / \           / \
 * 1   4   -->   1   4
 * /             / \
 * 3             3   6
 * Challenge
 * Can you do it without recursion?
 * <p>
 * Notice
 * You can assume there is no duplicate values in this tree + node.
 */
public class Lintcode85 {
    /*
    * @param root: The root of the binary search tree.
    * @param node: insert this node into the binary search tree
    * @return: The root of the new binary search tree.
    */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        } else {
            TreeNode currentNode = root;
            while (currentNode != null) {
                if (currentNode.val < node.val) {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode.right = node;
                        break;
                    }
                }
                if (currentNode.val > node.val) {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        currentNode.left = node;
                        break;
                    }
                }
            }

            return root;
        }
    }
}
