package com.github.leetcode.easy;

import apple.laf.JRSUIUtils;
import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 22:40
 * @Description: Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * <p>
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
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
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class Leetcode897 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(379);
        root.left = new TreeNode(826);
        Leetcode897 leetcode897 = new Leetcode897();
        System.out.println(leetcode897.increasingBST(root));
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> nodeList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        generateStack(root, stack);
        TreeNode tmpNode = null;
        while (!stack.isEmpty()) {
            tmpNode = stack.pop();
            nodeList.add(tmpNode.val);
        }
        TreeNode result = new TreeNode(nodeList.get(0));
        TreeNode current = result;
        for (int i = 1; i < nodeList.size(); i++) {
            current.left = null;
            current.right = new TreeNode(nodeList.get(i));
            current = current.right;
        }
        return result;
    }

    private void generateStack(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            generateStack(root.right, stack);
        }
        stack.push(root);
        if (root.left != null) {
            generateStack(root.left, stack);
        }
    }
}
