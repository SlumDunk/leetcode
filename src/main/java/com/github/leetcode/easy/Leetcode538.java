package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original
 * key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 *
 * @author liuzhongda
 */
public class Leetcode538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;
        Leetcode538 leetcode538 = new Leetcode538();
        leetcode538.convertBST(root);

    }

    /**
     * 全局和变量
     */
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //从右边处理到左边
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
        }
        return root;
    }

}
