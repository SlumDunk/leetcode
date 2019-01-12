package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 11:04
 * @Description: Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example
 * Given binary tree {1,#,2,3},
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * <p>
 * return [3,2,1].
 */
public class Lintcode68 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList();
        } else {
            List<Integer> result = new ArrayList();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;
            TreeNode currentNode = null;
            stack.push(root);
            while (!stack.isEmpty()) {
                currentNode = stack.peek();
                if (prev == null || prev.left == currentNode || prev.right == currentNode) {
                    if (currentNode.left != null) {
                        stack.push(currentNode.left);
                    } else if (currentNode.right != null) {
                        stack.push(currentNode.right);
                    }
                } else if (prev == currentNode.left) {
                    if (currentNode.right != null) {
                        stack.push(currentNode.right);
                    }
                } else {
                    result.add(currentNode.val);
                    stack.pop();
                }
                prev = currentNode;
            }
            return result;
        }
    }
}
