package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 07:40
 * @Description: A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 * <p>
 * Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
 * <p>
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * Output: [null,1,[1,2]]
 * Example 2:
 * <p>
 * Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The initial given tree is complete and contains between 1 and 1000 nodes.
 * CBTInserter.insert is called at most 10000 times per test case.
 * Every value of a given or inserted node is between 0 and 5000.
 */
public class Leetcode919 {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> q = new LinkedList();

        public CBTInserter(TreeNode root) {
            this.root = root;
            q.add(root);
            //走到最后一个节点
            boolean flag = true;
            while (flag) {
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.peek();
                    if (node.left == null && node.right == null) {
                        flag = false;
                        break;
                    }
                    if (node.left != null && node.right != null) {
                        node = q.poll();
                        q.add(node.left);
                        q.add(node.right);
                    } else {
                        if (node.left != null)
                            q.add(node.left);
                        if (node.right != null)
                            q.add(node.right);
                        flag = false;
                        break;
                    }
                }
            }
        }

        public int insert(int v) {
            TreeNode node = q.peek();
            TreeNode newNode = new TreeNode(v);
            if (node.left == null)
                node.left = newNode;
            else
                node.right = newNode;
            //父节点已经是满节点了
            if (node.left != null && node.right != null)
                q.poll();
            q.add(newNode);
            return node.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }

}
