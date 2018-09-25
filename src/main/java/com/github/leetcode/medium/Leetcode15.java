package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 15:33
 * @Description: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int sum = 0;
            int p = i + 1, q = n - 1;
            while (p < q) {
                sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[p]);
                    item.add(nums[q]);
                    list.add(item);
                    while (++p < q && nums[p - 1] == nums[p]) {

                    }
                    while (--q > p && nums[q + 1] == nums[q]) {

                    }
                } else if (sum > 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return list;
    }
}
