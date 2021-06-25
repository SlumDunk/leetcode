package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.
 * <p>
 * The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.
 * <p>
 * (Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Explanation: Diameter is shown in red color.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,null,3,4,null,5,null,6]
 * Output: 4
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 7
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [1, 104].
 */
public class Leetcode1522 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int max = 0;

    public int diameter(Node root) {
        if (root == null) return max;
        helper(root);
        return max;
    }

    private int helper(Node root) {
        int d1 = 0, d2 = 0;
        if (root == null) {
            return 0;
        }
        for (Node child :
                root.children) {
            int distance = 1 + helper(child);
            if (distance > d1) {
                d2 = d1;
                d1 = distance;
            } else if (distance > d2) {
                d2 = distance;
            }
        }
        max = Math.max(max, d1 + d2);
        return Math.max(d1, d2);
    }
}
