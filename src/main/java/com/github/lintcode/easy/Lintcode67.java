package com.github.lintcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 11:03
 * @Description: Given a binary tree, return the inorder traversal of its nodes' values.
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
 * return [1,3,2].
 * <p>
 * Challenge
 * Can you do it without recursion?
 */
public class Lintcode67 {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        } else {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
