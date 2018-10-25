package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 18:30
 * @Description: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> alist = new ArrayList<Integer>();
        if (root != null)
            dfs(alist, list, root, sum);
        return list;
    }

    public void dfs(List<Integer> alist, List<List<Integer>> list, TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                alist.add(root.val);
                list.add(new ArrayList<Integer>(alist));
                alist.remove(alist.size() - 1);
            }
            return;
        }
        alist.add(root.val);
        if (root.left == null)
            dfs(alist, list, root.right, sum - root.val);
        else if (root.right == null)
            dfs(alist, list, root.left, sum - root.val);
        else {
            List<Integer> alistCopy = new ArrayList<Integer>(alist);
            dfs(alist, list, root.right, sum - root.val);
            alist = alistCopy;
            dfs(alist, list, root.left, sum - root.val);
        }

    }
}
