package com.github.leetcode.easy;

import apple.laf.JRSUIUtils;
import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * <p>
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Leetcode501 {

    public static void main(String[] args) {
        Leetcode501 leetcode501 = new Leetcode501();
        leetcode501.findMode(null);
    }

    public int[] findMode(TreeNode root) {
        //中序遍历 递增有序的数组
        List<Integer> resultList = new ArrayList<Integer>();
        Integer mx = 0, cnt = 1;
        //保存上一个节点
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null) {
                cnt = root.val == pre.val ? cnt + 1 : 1;
            }
            if (cnt >= mx) {
                //找到新的mod，已有的结果集需要清空
                if (cnt > mx) resultList.clear();
                resultList.add(root.val);
                mx = cnt;
            }
            pre = root;
            //对右子树进行处理
            root = root.right;
        }
        int[] res = new int[resultList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
}
