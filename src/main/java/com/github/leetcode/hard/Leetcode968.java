package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 09:57
 * @Description: Given a binary tree, we install cameras on the nodes of the tree.
 * <p>
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * Example 2:
 * <p>
 * <p>
 * Input: [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 */
public class Leetcode968 {
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int val = helper(root);

        return val + (root.val == 0 ? 1 : 0);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int leftCameras = helper(root.left);
        int rightCameras = helper(root.right);
        //孩子都被照亮，但没放置相机，忽略

        //有孩子没被照亮
        if ((root.left != null && root.left.val == 0) || (root.right != null && root.right.val == 0)) {
            root.val = 1;
        }
        //有孩子放置相机
        else if ((root.left != null && root.left.val == 1) || (root.right != null && root.right.val == 1)) {
            root.val = 2;
        }

        return leftCameras + rightCameras + (root.val == 1 ? 1 : 0);
    }
}
