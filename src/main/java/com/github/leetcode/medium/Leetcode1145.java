package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 9/13/19 21:13
 * @Description: Two players play a turn based game on a binary tree.  We are given the root of this binary tree, and the number of nodes n in the tree.  n is odd, and each node has a distinct value from 1 to n.
 * <p>
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.  The first player colors the node with value x red, and the second player colors the node with value y blue.
 * <p>
 * Then, the players take turns starting with the first player.  In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 * <p>
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn.  If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 * <p>
 * You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.  If it is not possible, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * root is the root of a binary tree with n nodes and distinct node values from 1 to n.
 * n is odd.
 * 1 <= x <= n <= 100
 * Accepted
 */
public class Leetcode1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] children = helper(root, x);
        int p = n - 1 - children[0] - children[1];
        return Math.max(Math.max(p, children[0]), children[1]) > n / 2;
    }

    public int[] helper(TreeNode root, int x) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.val == x) {
            int l = count(root.left);
            int r = count(root.right);
            return new int[]{l, r};
        } else {
            int[] result_left_child = helper(root.left, x);
            int[] result_right_child = helper(root.right, x);

            if (result_left_child[0] == 0 && result_left_child[1] == 0) {
                return result_right_child;
            } else {
                return result_left_child;
            }
        }
    }

    public int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = count(node.left);
        int r = count(node.right);
        return l + r + 1;
    }
}
