package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 15:36
 * @Description: Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //中序遍历树
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            //当前节点进栈，然后往左走，直到走完
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //弹出栈
            TreeNode tmpNode = stack.pop();
            res.add(tmpNode.val);
            //右边节点变成当前节点
            root = tmpNode.right;

        }
        return res;
    }


    public List<Integer> inorderTraversal__(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (root == null) {
            return resultList;
        } else {
            //helper(root,resultList);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            while (!stack.isEmpty() || current != null) {
                //先处理左子树
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                //处理当前节点
                current = stack.pop();
                resultList.add(current.val);
                //根节点取到了，处理他的右子树
                current = current.right;
            }
            return resultList;
        }
    }


    public List<Integer> inorderTraversal___(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (root == null) {
            return resultList;
        } else {
            //helper(root,resultList);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode cur = stack.pop();
                resultList.add(cur.val);
                root = cur.right;

            }
            return resultList;
        }
    }

    /**
     * 递归版本
     *
     * @param node
     * @param resultList
     */
    public void helper(TreeNode node, List<Integer> resultList) {
        if (node == null) {
            return;
        }
        helper(node.left, resultList);

        resultList.add(node.val);

        helper(node.right, resultList);
    }

    public static void main(String[] args) {
        Leetcode94 leetcode94 = new Leetcode94();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;
        leetcode94.inorderTraversal___(root);
    }
}
