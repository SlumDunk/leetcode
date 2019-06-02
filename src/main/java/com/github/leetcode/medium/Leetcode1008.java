package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 5/30/19 18:24
 * @Description: Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class Leetcode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        } else {
            return construct(preorder, Integer.MAX_VALUE, new int[]{0});
        }
    }

    /**
     * @param preorder
     * @param maxValue 右边界
     * @param index    开始位置索引
     * @return
     */
    private TreeNode construct(int[] preorder, int maxValue, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] >= maxValue) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = construct(preorder, root.val, index);
        root.right = construct(preorder, maxValue, index);
        return root;
    }
}
