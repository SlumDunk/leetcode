package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 */
public class Leetcode572 {

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        TreeNode leftNode = new TreeNode(4);
        TreeNode leftChildNode = new TreeNode(1);
        TreeNode rightChildNode = new TreeNode(2);
        TreeNode rlChildNode = new TreeNode(0);
        rightChildNode.left = rlChildNode;
        leftNode.left = leftChildNode;
        leftNode.right = rightChildNode;
        TreeNode rightNode = new TreeNode(5);
        s.left = leftNode;
        s.right = rightNode;

        TreeNode t = new TreeNode(4);
        TreeNode tLeftNode = new TreeNode(1);
        TreeNode tRightNode = new TreeNode(2);
        t.left = tLeftNode;
        t.right = tRightNode;

        Leetcode572 leetcode572 = new Leetcode572();
        System.out.println(leetcode572.isSubtree(s, t));
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        //递归判断，是s的子树或是s左子树的子树或是s右子树的子树
        if (s == null) {
            return false;
        }
        //从当前节点出发找到子树
        if (isSame(s, t)) {
            return true;
        }
        //从左子节点出发寻找子树和从右子节点出发寻找子树
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两棵树是否一样
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
