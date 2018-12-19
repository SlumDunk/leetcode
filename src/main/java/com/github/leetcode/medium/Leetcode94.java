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
            //左边的先进栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //弹出栈
            TreeNode tmpNode = stack.pop();
            res.add(tmpNode.val);
            //右边节点赋给root
            root = tmpNode.right;

        }
        return res;
    }
}
