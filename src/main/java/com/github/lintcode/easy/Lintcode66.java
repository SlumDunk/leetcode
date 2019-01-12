package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 09:55
 * @Description: Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example
 * Given:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * return [1,2,4,5,3].
 * <p>
 * Challenge
 * Can you do it without recursion?
 */
public class Lintcode66 {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        } else {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode currentNode = null;
            while (!stack.isEmpty()) {
                currentNode = stack.pop();
                result.add(currentNode.val);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
            return result;
        }
    }
}
