package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 14:57
 * @Description: Given a binary search tree and a range [k1, k2], return all elements in the given range.
 * <p>
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 * <p>
 * 20
 * /  \
 * 8   22
 * / \
 * 4   12
 */
public class Lintcode11 {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        } else {
            dfs(root, result, k1, k2);
            return result;
        }
    }

    public void dfs(TreeNode node, List<Integer> result, int k1, int k2) {
        if (node == null) {
            return;
        } else {
            if (node.val > k1) {
                dfs(node.left, result, k1, k2);
            }
            if (k1 <= node.val && k2 >= node.val) {
                result.add(node.val);
            }
            if (node.val < k2) {
                dfs(node.right, result, k1, k2);
            }
        }
    }


    List<Integer> ans = new ArrayList<>();

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange__(TreeNode root, int k1, int k2) {
        // write your code here
        if (root == null) {
            return ans;
        } else {
            helper(root, k1, k2);
            return ans;
        }
    }

    public void helper(TreeNode node, int k1, int k2) {
        if (node == null) {
            return;
        } else {
            if (node.val > k1) {
                helper(node.left, k1, k2);
            }
            if (node.val >= k1 && node.val <= k2) {
                ans.add(node.val);
            }
            if (node.val < k2) {
                helper(node.right, k1, k2);
            }

        }
    }
}
