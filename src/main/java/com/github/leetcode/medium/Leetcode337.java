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

    /**
     * 抢劫某棵树的收益
     *
     * @param root
     * @return
     */
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        //抢劫当前节点的收益和不抢劫当前节点的收益
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


    class Pair {
        TreeNode node;
        int rob;
        int noRob;

        public Pair(TreeNode node, int rob, int noRob) {
            this.node = node;
            this.rob = rob;
            this.noRob = noRob;
        }
    }

    public int rob__(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //抢左子树的获取的最大收益+抢右子树的最大收益><=抢根节点的最大收益
        Pair result = helper(root);
        return Math.max(result.rob, result.noRob);
    }

    public Pair helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Pair(node, node.val, 0);
        } else {
            Pair left = null, right = null, current = new Pair(node, 0, 0);
            if (node.left != null) {
                left = helper(node.left);
            }

            if (node.right != null) {
                right = helper(node.right);
            }

            current.rob = node.val + (left != null ? left.noRob : 0) + (right != null ? right.noRob : 0);
            current.noRob = (left != null ? Math.max(left.rob, left.noRob) : 0) + (right != null ? Math.max(right.rob, right.noRob) : 0);

            return current;
        }
    }
}
