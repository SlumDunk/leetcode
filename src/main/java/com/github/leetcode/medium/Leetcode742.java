package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 5/11/19 16:23
 * @Description: Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
 * <p>
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 * <p>
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 * 1
 * / \
 * 3   2
 * <p>
 * Output: 2 (or 3)
 * <p>
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 * Example 2:
 * <p>
 * Input:
 * root = [1], k = 1
 * Output: 1
 * <p>
 * Explanation: The nearest leaf node is the root node itself.
 * Example 3:
 * <p>
 * Input:
 * root = [1,2,3,4,null,null,null,5,null,6], k = 2
 * Diagram of binary tree:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * /
 * 5
 * /
 * 6
 * <p>
 * Output: 3
 * Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
 * Note:
 * root represents a binary tree with at least 1 node and at most 1000 nodes.
 * Every node has a unique node.val in range [1, 1000].
 * There exists some node in the given binary tree for which node.val == k.
 */
public class Leetcode742 {
    public int findClosestLeaf(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        findNum(k, root, st);
        int i = 0;
        int hMin = Integer.MAX_VALUE;
        int ans = -1;
        while (!st.isEmpty()) {
            int[] curr = findMin(st.pop());
            if (curr[1] + i < hMin) {
                hMin = curr[1] + i;
                ans = curr[0];
            }
            i++;
        }
        return ans;
    }

    /**
     * 查找离当前节点最近的叶子节点
     *
     * @param curr
     * @return
     */
    private int[] findMin(TreeNode curr) {
        int[] ans = new int[2];
        ans[1] = Integer.MAX_VALUE;
        traverse(curr, ans, 0);
        return ans;
    }

    private void traverse(TreeNode root, int[] ans, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level < ans[1]) {
                ans[1] = level;
                ans[0] = root.val;
            }
            return;
        }
        traverse(root.left, ans, level + 1);
        traverse(root.right, ans, level + 1);
        return;
    }

    /**
     * 查找值为k的节点，栈里头存储从根节点到目标节点访问过的所有节点
     *
     * @param k
     * @param root
     * @param st
     * @return
     */
    private boolean findNum(int k, TreeNode root, Stack<TreeNode> st) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            st.push(root);
            return true;
        }
        st.push(root);
        boolean left = findNum(k, root.left, st);
        if (left)
            return true;
        boolean right = findNum(k, root.right, st);
        if (right)
            return true;
        st.pop();
        return false;
    }

}
