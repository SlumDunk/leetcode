package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its max depth, which is 3.
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class Leetcode559 {
    public static void main(String[] args) {
        Leetcode559 leetcode559 = new Leetcode559();
        Node firstChildNode = new Node(3, null);
        Node secondChildNode = new Node(2, null);
        Node lastChildNode = new Node(4, null);
        List<Node> children = new ArrayList<Node>();
        children.add(firstChildNode);
        children.add(secondChildNode);
        children.add(lastChildNode);
        Node root = new Node(1, children);

        System.out.println(leetcode559.maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        List<Integer> depthList = new ArrayList<Integer>();
        for (Node node : root.children) {
            depthList.add(maxDepth(node));
        }
        Collections.sort(depthList);
        return depthList.get(depthList.size() - 1) + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
