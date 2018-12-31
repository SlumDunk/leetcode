package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to
 * the given target.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 *
 * @author liuzhongda
 */
public class Leetcode653 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }

    /**
     * @param root 根节点
     * @param cur  当前节点
     * @param k    目标值
     * @return
     */
    private boolean helper(TreeNode root, TreeNode cur, int k) {
        if (root == null) {
            return false;
        }
        //从当前节点出发，或者从当前节点左子节点出发，或者从当前节点的右子节点出发
        return search(root, cur, k - root.val) || helper(root.left, cur, k) || helper(root.right, cur, k);
    }

    /**
     * @param root 出发节点
     * @param cur  当前节点
     * @param k    目标值
     * @return
     */
    private boolean search(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;
        //两个节点必须不同
        if (root != cur && k == cur.val) return true;
        if (cur.val > k) {
            return search(root, cur.left, k);
        } else {
            return search(root, cur.right, k);
        }
    }
}
