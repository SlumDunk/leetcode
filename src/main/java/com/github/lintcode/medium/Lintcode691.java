package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 11:13
 * @Description: In a binary search tree, (Only) two nodes are swapped. Find out these nodes and swap them. If there no node swapped, return original root of tree.
 * <p>
 * Example
 * Given a binary search tree:
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 1   3
 * return
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 */
public class Lintcode691 {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        } else {
            traverse(root);
            if (firstElement != null && secondElement != null) {
                int temp = firstElement.val;
                firstElement.val = secondElement.val;
                secondElement.val = temp;
            }
            return root;

        }
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        } else {
            traverse(root.left);
            //1,5,3,4,2
            if (firstElement == null && root.val < lastElement.val) {
                firstElement = lastElement;
            }
            if (firstElement != null && root.val < lastElement.val) {
                secondElement = root;
            }

            lastElement = root;
            traverse(root.right);
        }
    }
}
