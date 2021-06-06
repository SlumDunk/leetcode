package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 * <p>
 * If there are no nodes with an even-valued grandparent, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */
public class Leetcode1315 {
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    if (cur.val % 2 == 0) {
                        sum += cur.left.left == null ? 0 : cur.left.left.val;
                        sum += cur.left.right == null ? 0 : cur.left.right.val;
                    }
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    if (cur.val % 2 == 0) {
                        sum += cur.right.left == null ? 0 : cur.right.left.val;
                        sum += cur.right.right == null ? 0 : cur.right.right.val;
                    }
                    queue.offer(cur.right);
                }
            }
        }
        return sum;
    }
}
