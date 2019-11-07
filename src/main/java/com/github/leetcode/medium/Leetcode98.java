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


    class Result {
        boolean isValid;
        int min;
        int max;

        public Result() {
            this.isValid = true;
            this.min = 0;
            this.max = 0;
        }
    }

    public boolean isValidBST__(TreeNode root) {
        if (root == null) {
            return true;
        } else {
//            return helper(root).isValid;
            return helper2(root);
        }

    }

    public Result helper(TreeNode node) {
        Result result = new Result();
        if (node.left == null && node.right == null) {
            result.min = node.val;
            result.max = node.val;
            return result;
        }
        //跟右子树最小值比较
        if (node.right != null && node.left != null) {
            Result right = helper(node.right);
            //跟左子树最大值比较
            Result left = helper(node.left);
            //左右子树也满足二叉搜索树条件
            if (node.val > left.max && node.val < right.min && left.isValid && right.isValid) {
                result.min = Math.min(Math.min(node.val, left.min), right.min);
                result.max = Math.max(Math.max(node.val, left.max), right.max);
            } else {
                result.isValid = false;
                result.min = Math.min(Math.min(node.val, left.min), right.min);
                result.max = Math.max(Math.max(node.val, left.max), right.max);
            }
        } else if (node.left == null) {
            Result right = helper(node.right);
            //左右子树也满足二叉搜索树条件
            if (node.val < right.min && right.isValid) {
                result.min = Math.min(node.val, right.min);
                result.max = Math.max(node.val, right.max);
            } else {
                result.isValid = false;
                result.min = Math.min(node.val, right.min);
                result.max = Math.max(node.val, right.max);
            }
        } else {
            //跟左子树最大值比较
            Result left = helper(node.left);
            //左右子树也满足二叉搜索树条件
            if (node.val > left.max && left.isValid) {
                result.min = Math.min(node.val, left.min);
                result.max = Math.max(node.val, left.max);
            } else {
                result.isValid = false;
                result.min = Math.min(node.val, left.min);
                result.max = Math.max(node.val, left.max);
            }
        }

        return result;

    }

    public boolean helper2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                root = cur.right;
            }

        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
