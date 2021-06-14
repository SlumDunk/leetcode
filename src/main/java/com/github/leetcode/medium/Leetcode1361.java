package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 * <p>
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 * <p>
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 * Example 3:
 * <p>
 * <p>
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 * Example 4:
 * <p>
 * <p>
 * Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class Leetcode1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 入度
        int[] degrees = new int[n];

        Integer root = null;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                degrees[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                degrees[rightChild[i]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (degrees[i] > 1) {
                return false;
            } else if (degrees[i] == 0) {
                if (root != null) {
                    return false;
                }
                root = i;
            }
        }

        if (root == null) {
            return false;
        }

        //检测是不是有环
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            if (leftChild[cur] != -1) {
                queue.offer(leftChild[cur]);
            }

            if (rightChild[cur] != -1) {
                queue.offer(rightChild[cur]);
            }
        }
        return count == n;
    }
}
