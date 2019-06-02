package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 18:08
 * @Description: Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 * <p>
 * <p>
 * Note:
 * <p>
 * The tree will have between 1 and 1000 nodes.
 * Each node's value will be between 0 and 1000.
 */
public class Leetcode987 {
    class Point implements Comparable<Point> {
        int x, y;
        TreeNode node;

        Point(TreeNode node, int x, int y) {
            this.x = x;
            this.y = y;
            this.node = node;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x && this.y == o.y) {
                return this.node.val - o.node.val;
            }
            return o.y - this.y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Point>> map = new TreeMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(root, 0, 0));
        while (!queue.isEmpty()) {
            Point top = queue.poll();
            if (!map.containsKey(top.x)) {
                map.put(top.x, new ArrayList<>());
            }
            map.get(top.x).add(top);
            if (top.node.left != null) {
                queue.offer(new Point(top.node.left, top.x - 1, top.y - 1));
            }
            if (top.node.right != null) {
                queue.offer(new Point(top.node.right, top.x + 1, top.y - 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Point> level :
                map.values()) {
            List<Integer> temp = new ArrayList<>();
            Collections.sort(level);
            for (Point p :
                    level) {
                temp.add(p.node.val);
            }
            result.add(temp);
        }
        return result;
    }
}
