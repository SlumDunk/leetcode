package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 14:58
 * @Description: Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * <p>
 * Output:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Examples 2:
 * <p>
 * Input: [3,9,8,4,0,1,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Examples 3:
 * <p>
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 */
public class Leetcode314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Integer> qCol = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        qCol.offer(0);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = qCol.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>(Arrays.asList(curr.val)));
            } else {
                map.get(col).add(curr.val);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
                qCol.offer(col - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                qCol.offer(col + 1);
            }
        }
        for (int n : map.keySet()) {
            results.add(map.get(n));
        }
        return results;
    }
}
