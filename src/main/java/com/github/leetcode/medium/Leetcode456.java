package com.github.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 20:31
 * @Description: Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Leetcode456 {
    /**
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        //存储左边部分的最小值
        int[] leftMin = nums.clone();
        for (int i = 1; i < leftMin.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], leftMin[i]);
        }

        TreeSet<Integer> bst = new TreeSet<>();
        //从后往前扫
        for (int i = nums.length - 1; i > 0; i--) {
            int num = nums[i];
            //右边找到比当前值小的最大值
            if (bst.lower(num) != null) {
                int right = bst.lower(num);
                //寻找左边的最小值
                int left = leftMin[i - 1];
                if (left < right && left < num) {
                    return true;
                }
            }
            bst.add(num);
        }

        return false;
    }
}
