package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 12:09
 * @Description: You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class Leetcode315 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        //从后往前推
        TreeNode root = new TreeNode(nums[len - 1]);
        result.add(0);
        for (int i = len - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            result.add(count);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 在树里头找到合适的位置，插入节点，节点值为num
     *
     * @param root
     * @param num
     * @return
     */
    private int insertNode(TreeNode root, int num) {
        int count = 0;
        //寻找到合适的插入位置
        while (true) {
            if (num <= root.val) {//往左走
                root.count++;//更新count
                if (root.left == null) {
                    root.left = new TreeNode(num);
                    break;
                } else {
                    root = root.left;
                }
            } else {//往右走
                count += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(num);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return count;
    }

    /**
     * 树节点
     */
    class TreeNode {
        TreeNode left, right;
        int val;
        /**
         * 存放小于等于val的节点数量
         */
        int count = 1;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
