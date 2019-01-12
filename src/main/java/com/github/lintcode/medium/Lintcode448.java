package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 11:32
 * @Description: Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * If the given node has no in-order successor in the tree, return null.
 * <p>
 * Example
 * Given tree = [2,1] and node = 1:
 * <p>
 * 2
 * /
 * 1
 * return node 2.
 * <p>
 * Given tree = [2,1,3] and node = 2:
 * <p>
 * 2
 * / \
 * 1   3
 * return node 3.
 * <p>
 * Challenge
 * O(h), where h is the height of the BST.
 * <p>
 * Notice
 * It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
 */
public class Lintcode448 {
    /*
    * @param root: The root of the BST.
    * @param p: You need find the successor node of p.
    * @return: Successor of p.
    */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        //结束循环的条件是root为空或者root==p
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        //root为空
        if (root == null) {
            return null;
        }
        //右子树为空，直接返回successor
        if (root.right == null) {
            return successor;
        }

        //找到右子树的最左节点
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
