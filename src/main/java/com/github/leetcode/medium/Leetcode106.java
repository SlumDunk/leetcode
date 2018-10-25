package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 18:10
 * @Description: Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode build(int poststart, int instart, int inend, int[] inorder, int[] postorder) {
        if (poststart < 0 || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[poststart]);
        int inindex = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                inindex = i;
                break;
            }
        }
        root.right = build(poststart - 1, inindex + 1, inend, inorder, postorder);
        root.left = build(poststart - (inend - inindex) - 1, instart, inindex - 1, inorder, postorder);
        return root;
    }

}
