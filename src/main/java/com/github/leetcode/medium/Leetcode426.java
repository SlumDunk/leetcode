package com.github.leetcode.medium;

import com.github.collections.Deque;
import com.github.collections.impl.ArrayDeque;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/20/19 19:37
 * @Description: Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 * <p>
 * Let's take the following BST as an example, it may help you understand the problem better:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * <p>
 * The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.
 * <p>
 * The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 */
public class Leetcode426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * keep connecting the last node and curr node.
     * then connect the first node and last node.
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node first = null;
        Node last = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null) {
                first = root;
            }
            if (last != null) {
                last.right = root;
                root.left = last;
            }
            last = root;
            root = root.right;
        }
        first.left = last;
        last.right = first;
        return first;
    }

    public Node treeToDoublyList__(Node root) {
        //中序遍历
        if (root == null) {
            return null;
        } else {
            Stack<Node> stack = new Stack<Node>();
            Node first = null, last = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                Node cur = stack.pop();
                if (first == null) {
                    first = cur;
                }
                if (last != null) {
                    last.right = cur;
                    cur.left = last;
                }
                last = cur;
                if (cur.right != null) {
                    root = cur.right;
                }
            }
            first.left = last;
            last.right = first;
            return first;
        }
    }
}
