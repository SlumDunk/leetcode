package com.github.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.github.leetcode.vo.*;

/**
 * @Author: zerongliu
 * @Date: 8/30/18 21:10
 * @Description: Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its level order traversal:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class Leetcode429 {

    public static void main(String[] args) {
        Leetcode429 leetcode429 = new Leetcode429();
        Node root = new Node();
        root.val = 1;
        List<Node> _2childrenList = new ArrayList<Node>();
        Node _3Node = new Node();
        _3Node.val = 3;
        Node _5Node = new Node();
        _5Node.val = 5;
        Node _6Node = new Node();
        _6Node.val = 6;
        List<Node> _3childrenList = new ArrayList<Node>();
        _3childrenList.add(_5Node);
        _3childrenList.add(_6Node);
        _3Node.children = _3childrenList;

        Node _2Node = new Node();
        _2Node.val = 2;
        Node _4Node = new Node();
        _4Node.val = 4;
        _2childrenList.add(_3Node);
        _2childrenList.add(_2Node);
        _2childrenList.add(_4Node);
        root.children = _2childrenList;

        System.out.println(leetcode429.levelOrder(root));

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultList;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        Node tmpNode = null;
        List<Node> children = null;
        int len = 1, tmpLen = 0;
        int count = 0;
        List<Integer> subLevel = null;
        while (!queue.isEmpty()) {
            tmpNode = queue.poll();
            if (count == 0) {
                subLevel = new ArrayList<Integer>();
            }
            count++;
            subLevel.add(tmpNode.val);
            children = tmpNode.children;
            if (children != null && children.size() > 0) {
                for (int i = 0; i < children.size(); i++) {
                    queue.add(children.get(i));
                }
                tmpLen += children.size();
            }
            if (count == len) {
                resultList.add(subLevel);
                len = tmpLen;
                tmpLen = 0;
                count = 0;
            }
        }
        return resultList;
    }
}
