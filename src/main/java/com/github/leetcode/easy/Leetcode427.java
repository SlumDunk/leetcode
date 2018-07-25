package com.github.leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 * <p>
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 * <p>
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 * <p>
 * <p>
 * <p>
 * It can be divided according to the definition above:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 * <p>
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */
public class Leetcode427 {

    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        } else {
            int length = grid.length;

            return consctructTree(grid, 0, 0, length);
        }
    }

    private Node consctructTree(int[][] grid, int startRowIdx, int startColIdx, int length) {
        if (length == 1) {   //遍历到了最后的1*1的网格，创建节点
            return new Node(grid[startRowIdx][startColIdx] == 1 ? true : false, true, null, null, null, null);
        }
        length /= 2;
        Node node = new Node();

        Node topLeft = consctructTree(grid, startRowIdx, startColIdx, length);

        Node topRight = consctructTree(grid, startRowIdx, startColIdx + length, length);

        Node bottomLeft = consctructTree(grid, startRowIdx + length, startColIdx, length);

        Node bottomRight = consctructTree(grid, startRowIdx + length, startColIdx + length, length);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            Boolean v = topLeft.val;
            return new Node(v, true, null, null, null, null);
        } else {
            Node p = new Node(true, false, null, null, null, null);
            p.topLeft = topLeft;
            p.topRight = topRight;
            p.bottomLeft = bottomLeft;
            p.bottomRight = bottomRight;
            return p;
        }
    }


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
