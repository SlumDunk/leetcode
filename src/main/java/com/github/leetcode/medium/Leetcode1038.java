package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 08:59
 * @Description: Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 100.
 * Each node will have value between 0 and 100.
 * The given tree is a binary search tree.
 */
public class Leetcode1038 {
    public TreeNode bstToGst(TreeNode root) {
        ms=0;
        gst(root);
        return root;
    }

    /**
     * 保存大于当前节点值的节点的和
     */
    int ms=0;

    /**
     * right->root->left
     * @param root
     */
    public void gst(TreeNode root){
        if(root==null){
            return;
        }

        gst(root.right);
        ms+=root.val;
        root.val=ms;
        gst(root.left);

    }
}
