package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *
 * @author liuzhongda
 */
public class Leetcode637 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Double> averageOfLevels(TreeNode root) {
        //广度优先遍历
        List<Double> resultList = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            //每层节点个数
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode headNode = queue.poll();
                sum += headNode.val;
                if (headNode.left != null)
                    queue.add(headNode.left);
                if (headNode.right != null)
                    queue.add(headNode.right);
            }
            resultList.add(sum / size);
        }
        return resultList;
    }
}
