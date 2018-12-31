package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 21:45
 * @Description: The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Leetcode337 {
    public int rob(TreeNode root) {
        //返回抢劫root和不抢劫root两者的较大值
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        //寻找左子树的最大收益
        int[] left = robSub(root.left);
        //寻找右子树的最大收益
        int[] right = robSub(root.right);

        //不抢劫当前节点，所以它等于两个分支较大值的和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //抢劫当前节点，不抢劫两个子节点
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
