package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> postorder(Leetcode559.Node root) {
        if (root == null) {
            return null;
        }
        if (root.children != null && root.children.size() > 0) {
            for (Leetcode559.Node node : root.children
                    ) {
                postorder(node);
            }
        }
        resultList.add(root.val);
        return resultList;
    }
}
