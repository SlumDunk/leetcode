package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 19:54
 * @Description: Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                Integer[] pair = {i, j};

                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Integer[]>());
                }
                map.get(sum).add(pair);
            }
        }

        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            List<Integer[]> listA = map.get(key);
            List<Integer[]> listB = map.get(target - key);

            if (listA != null && listB != null) {
                for (Integer[] pairA : listA) {
                    int a0 = pairA[0], a1 = pairA[1];

                    for (Integer[] pairB : listB) {
                        int b0 = pairB[0], b1 = pairB[1];
                        if (a1 < b0) {  // to avoid repeat： a0 < a1, b0 < b1
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[a0]);
                            list.add(nums[a1]);
                            list.add(nums[b0]);
                            list.add(nums[b1]);
                            if (!res.contains(list)) res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}
