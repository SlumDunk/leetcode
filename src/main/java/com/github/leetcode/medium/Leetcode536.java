package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 21:51
 * @Description: You need to construct a binary tree from a string consisting of parenthesis and integers.
 * <p>
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * <p>
 * You always start to construct the left child node of the parent first if it exists.
 * <p>
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 */
public class Leetcode536 {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // 栈顶放的是最近的父节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            // 遇到数字
            if (c == '-' || (c >= '0' && c <= '9')) {
                String val = "" + c;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    val += s.charAt(i + 1);
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(val));
                //如果父节点不为空，那么新节点作为左子节点或右子节点
                if (root != null) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }
                //进栈
                stack.push(node);
            } else if (c == '(') {
                //取得当前父亲节点
                root = stack.peek();
            } else {
                //当前栈顶节点没有子节点
                stack.pop();
            }
            i++;
        }
        return stack.pop();
    }
}
