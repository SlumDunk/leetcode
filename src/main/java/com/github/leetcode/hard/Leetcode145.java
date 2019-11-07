package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 14:04
 * @Description: Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        } else {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            //必须记住前置节点
            TreeNode prev = null;
            TreeNode currentNode = null;
            while (!stack.isEmpty()) {
                currentNode = stack.peek();
                //从上往下入栈，优先入栈左子树
                if (prev == null || prev.left == currentNode || prev.right == currentNode) {
                    if (currentNode.left != null) {
                        stack.push(currentNode.left);
                    } else if (currentNode.right != null) {
                        stack.push(currentNode.right);
                    }
                } else if (prev == currentNode.left) {//traversal up from left
                    if (currentNode.right != null) {
                        stack.push(currentNode.right);
                    }
                } else {//traversal up from right
                    result.add(currentNode.val);
                    stack.pop();
                }
                prev = currentNode;
            }
            return result;
        }
    }


    public List<Integer> postorderTraversal__(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        } else {
            // helper(root,result);
            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    result.addFirst(root.val);
                    root = root.right;
                }

                TreeNode cur = stack.pop();
                root = cur.left;

            }

            return result;
        }
    }

    public void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            helper(node.left, result);
            helper(node.right, result);
            result.add(node.val);
        }
    }

    public List<Integer> postorderTraversal___(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        } else {
            // helper(root,result);
            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    result.addFirst(root.val);
                    stack.push(root.left);
                    stack.push(root.right);
                    root = null;
                }
                if (!stack.isEmpty()) {
                    root = stack.pop();
                }

            }

            return result;
        }
    }
}
