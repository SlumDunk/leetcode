package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
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
        //结果集
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        //中间结果集
        List<Integer> tempList = new ArrayList<Integer>();
        if (root != null)
            dfs(tempList, resultList, root, sum, 0);
        return resultList;
    }

    /**
     * @param tempList   中间结果集
     * @param resultList 结果集
     * @param root
     * @param target     目标和值
     * @param current    当前和值
     */
    public void dfs(List<Integer> tempList, List<List<Integer>> resultList, TreeNode root, int target, int current) {
        //走到叶子节点
        if (root.left == null && root.right == null) {
            if (current + root.val == target) {
                tempList.add(root.val);
                resultList.add(new ArrayList<Integer>(tempList));
                tempList.remove(tempList.size() - 1);
            }
            return;
        }
        tempList.add(root.val);
        if (root.left == null) {//左分支为空
            dfs(tempList, resultList, root.right, target, current + root.val);
        } else if (root.right == null) {//右分支为空
            dfs(tempList, resultList, root.left, target, current + root.val);
        } else {//左右分支都非空
            List<Integer> copy = new ArrayList<Integer>(tempList);
            dfs(tempList, resultList, root.right, target, current + root.val);
            tempList = copy;
            dfs(tempList, resultList, root.left, target, current + root.val);
        }

    }


    public List<List<Integer>> pathSum__(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();

            helper(root, temp, result, sum);
            return result;
        }
    }


    public void helper(TreeNode node, List<Integer> temp, List<List<Integer>> result, int sum) {
        if (node == null) {
            return;
        }
        if (sum == node.val && node.left == null && node.right == null) {
            temp.add(node.val);
            result.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
        } else {
            temp.add(node.val);
            helper(node.left, temp, result, sum - node.val);
            helper(node.right, temp, result, sum - node.val);
            temp.remove(temp.size() - 1);
        }
    }
}
