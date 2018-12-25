package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 8/31/18 11:41
 * @Description: Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class Leetcode532 {

    public static void main(String[] args) {

    }

    public int findPairs(int[] nums, int k) {
        //对数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        int result = 0;
        int count = 0;//加上一个标志位
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if (k == 0) {//k等于0时特殊处理
                if (numSet.contains(nums[i]) && count == 1) {//已经有一个了，第二次出现，结果集加1
                    result++;
                    count++;
                } else if (!numSet.contains(nums[i])) {//集合中没有元素，添加进去，同时将标志位置为1
                    numSet.add(nums[i]);
                    count = 1;
                }
            } else {
                //重复的元素不计算
                if (!numSet.contains(nums[i]) && numSet.contains(nums[i] - k)) {
                    result++;
                }
                numSet.add(nums[i]);
            }

        }
        return result;
    }
}
