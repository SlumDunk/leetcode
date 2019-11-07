package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 20:34
 * @Description: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Leetcode129 {
    /**
     * 全局和值
     */
    int sum=0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return sum;
    }

    /**
     * @param root   当前节点
     * @param preSum 当前和
     */
    public void dfs(TreeNode root, int preSum) {
        //走到叶子节点，添加到全局和值
        if (root.left == null && root.right == null) {
            sum += preSum;
        }
        //左子节点非空
        if (root.left != null) {
            dfs(root.left, preSum * 10 + root.left.val);
        }
        //右子节点非空
        if (root.right != null) {
            dfs(root.right, preSum * 10 + root.right.val);
        }
    }


    public int sumNumbers__(TreeNode root) {
        if (root == null) {
            return sum;
        } else {
            List<Integer> temp = new ArrayList<Integer>();
            helper(root, temp);
            return sum;
        }
    }

    public void helper(TreeNode node, List<Integer> temp) {
        if (node != null && node.left == null && node.right == null) {
            temp.add(node.val);
            sum += list2sum(temp);
            temp.remove(temp.size() - 1);
        } else {
            if (node == null) {
                return;
            } else {
                temp.add(node.val);
                helper(node.left, temp);
                helper(node.right, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public int list2sum(List<Integer> temp) {
        int subsum = 0;

        for (Integer val : temp) {
            subsum = (subsum * 10 + val);
        }
        return subsum;
    }

}
