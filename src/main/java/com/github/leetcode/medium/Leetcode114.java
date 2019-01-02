package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 18:45
 * @Description: Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Leetcode114 {
    public void flatten(TreeNode root) {
        //先根遍历，原来的左节点出栈时调整成右节点
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //右节点入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            //左节点入栈
            if (cur.left != null) {
                stack.push(cur.left);
            }
            //栈顶元素成为现有节点的右节点
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            //切断原有左分支
            cur.left = null;
        }
    }

    /**
     * 保存的是上一个父节点
     */
    private TreeNode lastNode = null;

    /**
     * @param root 当前节点
     */
    public void flatten_recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        //必须创建变量，因为在递归过程中会调整root的左右指针指向
        //左子树
        TreeNode left = root.left;
        //右子树
        TreeNode right = root.right;
        //先解决左边的子树
        flatten_recursive(left);
        //再解决右边的子树
        flatten_recursive(right);
    }
}
