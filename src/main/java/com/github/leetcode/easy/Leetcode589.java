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

}
