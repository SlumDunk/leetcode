package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 17:42
 * @Description: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();//返回的最终结果
        Queue<TreeNode> queue = new LinkedList<>();//用来存放每一层的节点

        //处理第一个节点（root）
        if (root == null)
            return result;
        else {
            List<Integer> temp = new ArrayList<>();//存放暂时的结果
            temp.add(root.val);
            queue.offer(root);
            result.add(temp);
        }

        while (!queue.isEmpty()) {
            int i = queue.size();
            List<Integer> tempReslut = new ArrayList<>();//存放暂时的结果
            while (i > 0)//遍历这一层的所有节点
            {
                TreeNode tNode = queue.poll();
                if (tNode.left != null) {
                    tempReslut.add(tNode.left.val);
                    queue.offer(tNode.left);
                }
                if (tNode.right != null) {
                    tempReslut.add(tNode.right.val);
                    queue.offer(tNode.right);
                }
                i--;
            }
            if (!tempReslut.isEmpty()) result.add(tempReslut);
        }

        return result;
    }
}
