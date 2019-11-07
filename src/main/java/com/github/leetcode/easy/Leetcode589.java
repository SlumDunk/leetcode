package com.github.leetcode.easy;

import com.github.leetcode.vo.Node;

import java.util.*;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 */
public class Leetcode589 {

    public List<Integer> preorder(Node root) {
        //对树进行先根遍历
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        List<Node> children = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            children = root.children;
            if (children != null && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }


    public List<Integer> preorder__(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            // helper(root,result);
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
            return result;
        }
    }

    public void helper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, result);
            }
        }

    }

    public List<Integer> preorder___(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            // helper(root,result);
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || root != null) {

                if (root != null) {
                    result.add(root.val);
                    if (root.children != null) {
                        for (int i = root.children.size() - 1; i >= 0; i--) {
                            stack.push(root.children.get(i));
                        }
                    }
                    root = null;
                }

                if (!stack.isEmpty()) {
                    root = stack.pop();
                }
            }
            return result;
        }
    }

}
