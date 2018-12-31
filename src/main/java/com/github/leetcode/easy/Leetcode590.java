package com.github.leetcode.easy;

import com.github.leetcode.vo.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class Leetcode590 {
    List<Integer> resultList = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        //后根遍历
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        List<Node> children = null;
        while (!stack.isEmpty() || root != null) {
            //走到最左
            while (root != null) {
                stack.push(root);
                children = root.children;
                //所有子节点进栈
                if (children != null && children.size() > 0) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                    //防止再次入栈
                    root.children = null;
                    root = stack.pop();
                } else {
                    root = null;
                }
            }
            //栈顶元素出栈
            result.add(stack.pop().val);
            //下个要处理的元素
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return result;
    }

    public List<Integer> postorderRecursive(Node root) {
        if (root == null) {
            return null;
        }
        if (root.children != null && root.children.size() > 0) {
            for (Node node : root.children
                    ) {
                postorder(node);
            }
        }
        resultList.add(root.val);
        return resultList;
    }
}
