package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 16:39
 * @Description: Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * <p>
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * <p>
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 1 and 500.
 * The values of each node are unique.
 */
public class Leetcode865 {
    /**
     * 树的最大的深度
     */
    int maxd = -1;
    /**
     * 最大深度的节点
     */
    TreeNode deep = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        traverse(root, 0);

        return deep;
    }

    /**
     * 3 0
     * 5 1
     * 2 2
     * 7 3
     * 4 3
     * 返回子节点的最大深度
     *
     * @param node
     * @param d    从根节点到当前位置的深度
     * @return
     */
    private int traverse(TreeNode node, int d) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.left, d + 1);
        int right = traverse(node.right, d + 1);
        int ld = left + d;
        int rd = right + d;
        if (maxd < d) {
            maxd = d;
        }
        if (ld == rd && maxd == ld) {//左右子树深度一致，且等于最大深度
            System.out.println(node.val);
            deep = node;
        }
        //返回当前节点子节点的最大深度
        return 1 + Math.max(left, right);
    }
}
