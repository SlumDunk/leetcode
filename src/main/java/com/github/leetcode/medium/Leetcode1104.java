package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 14:02
 * @Description: In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 * <p>
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 * <p>
 * <p>
 * <p>
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: label = 14
 * Output: [1,3,4,14]
 * Example 2:
 * <p>
 * Input: label = 26
 * Output: [1,2,6,10,26]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= label <= 10^6
 */
public class Leetcode1104 {
    /**
     * 每一层对称交换子节点
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<Integer>();
        result.add(label);
        int height = findHeight(label);
        while (label != 1) {
            int parent = label / 2;
            --height;
            //当前层开始元素下标
            int start = (int) (Math.pow(2, height));
            //当前层结束下标
            int end = start + (int) (Math.pow(2, height)) - 1;
            //挂到对称父节点上
            label = start + (end - parent);
            result.add(0, label);
        }
        return result;
    }

    /**
     * 返回节点所在的深度
     *
     * @param n
     * @return
     */
    int findHeight(int n) {
        int height = 0;
        while (n != 1) {
            n = n / 2;
            height++;
        }
        return height;
    }
}
