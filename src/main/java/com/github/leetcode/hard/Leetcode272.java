package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 22:20
 * @Description: Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class Leetcode272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) return;
        helper(res, root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) {
                res.removeFirst();
            } else {
                return;
            }
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }


}
