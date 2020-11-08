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
        //递归构建树
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     * @param preOrder
     * @param inOrder
     * @param preStart 先根排序的起始位置
     * @param inStart  中根排序的起始位置
     * @param inEnd    中根排序中树最后节点的位置
     * @return
     */
    public TreeNode build(int[] preOrder, int[] inOrder, int preStart, int inStart, int inEnd) {
        if (preStart > preOrder.length || inStart > inEnd) {
            return null;
        } else {
            //子树根节点
            TreeNode root = new TreeNode(preOrder[preStart]);
            //遍历中序数组，找到根节点的位置
            int index = -1;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == preOrder[preStart]) {
                    index = i;
                    break;
                }
            }
            //inStart...index-1构成左子树，index+1...inEnd构成右子树
            if (index != -1) {
                //中序根节点左侧的树节点构成左子树
                root.left = build(preOrder, inOrder, preStart + 1, inStart, index - 1);
                //中序根节点右侧构造右子树,先根排序数组中右侧子树的起始位置
                root.right = build(preOrder, inOrder, preStart + index - inStart + 1, index + 1, inEnd);
            }
            return root;
        }
    }


    /**
     * O(n)
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int prestart, int instart, int inend) {
        if (prestart >= preorder.length || instart > inend) {
            return null;
        } else {
            TreeNode root = new TreeNode(preorder[prestart]);
            int index = -1;
            for (int i = instart; i <= inend; i++) {
                if (inorder[i] == preorder[prestart]) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                root.left = helper(preorder, inorder, prestart + 1, instart, index - 1);

                root.right = helper(preorder, inorder, prestart + index - instart + 1, index + 1, inend);
            }
            return root;
        }
    }
}
