package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:04
 * @Description: Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return list;
        }
        //根节点先进栈，因为最先处理的是根节点，所以直接进栈即可，
        //不需要像中根遍历那样需要中间变量存储当前节点
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            //右子树先进栈
            if (node.right != null) {
                stack.push(node.right);
            }
            //左子树后进栈，先处理
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
