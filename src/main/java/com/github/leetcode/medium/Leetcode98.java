package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 16:06
 * @Description: Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's frequency
 * is 5 but its right child's frequency is 4.
 */
public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //中根遍历
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        //如果是有效的二叉树，那么中根遍历结果是个递增数组
        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }
}
