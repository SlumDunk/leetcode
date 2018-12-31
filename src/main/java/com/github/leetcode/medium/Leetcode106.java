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
    int[] inOrder;
    int[] postOrder;

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        this.inOrder = inOrder;
        this.postOrder = postOrder;
        //从后根序列数组的末尾往前推
        return build(postOrder.length - 1, 0, inOrder.length - 1);
    }

    /**
     * @param postEnd 子树后根序列的起始位置
     * @param inStart   子树中根序列的起始位置
     * @param inEnd     子树中根序列的终止位置
     * @return
     */
    private TreeNode build(int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.val) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            //构建右子树
            root.right = build(postEnd - 1, index + 1, inEnd);
            //构建左子树，后根序列的开始位置为原来的位置往前偏移右子树的节点长度
            root.left = build(postEnd - (inEnd - index) - 1, inStart, index - 1);
        }
        return root;
    }

}
