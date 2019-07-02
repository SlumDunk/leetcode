package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 17:45
 * @Description: We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.
 * <p>
 * Just as in the previous problem, the given tree was constructed from an list A (root = Construct(A)) recursively with the following Construct(A) routine:
 * <p>
 * If A is empty, return null.
 * Otherwise, let A[i] be the largest element of A.  Create a root node with value A[i].
 * The left child of root will be Construct([A[0], A[1], ..., A[i-1]])
 * The right child of root will be Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
 * Return root.
 * Note that we were not given A directly, only a root node root = Construct(A).
 * <p>
 * Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.
 * <p>
 * Return Construct(B).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [4,1,3,null,null,2], val = 5
 * Output: [5,4,null,1,3,null,null,2]
 * Explanation: A = [1,4,2,3], B = [1,4,2,3,5]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,2,4,null,1], val = 3
 * Output: [5,2,4,null,1,null,3]
 * Explanation: A = [2,1,5,4], B = [2,1,5,4,3]
 * Example 3:
 * <p>
 * <p>
 * Input: root = [5,2,3,null,1], val = 4
 * Output: [5,2,4,null,1,3]
 * Explanation: A = [2,1,5,3], B = [2,1,5,3,4]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= B.length <= 100
 */
public class Leetcode998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (val >= root.val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
