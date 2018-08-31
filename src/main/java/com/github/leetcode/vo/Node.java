package com.github.leetcode.vo;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 8/30/18 21:15
 * @Description:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
