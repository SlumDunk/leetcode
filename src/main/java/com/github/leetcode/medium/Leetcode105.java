package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 17:58
 * @Description: Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart > pre.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;//记录根节点的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        root.left = build(pre, in, preStart + 1, inStart, index - 1);//找出左子树的各个位置
        root.right = build(pre, in, preStart + index - inStart + 1, index + 1, inEnd);//找出右子树的各个位置
        return root;
    }
}
