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
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return resultList;
        } else {
            ////对元素索引没要求，可以先变成有序的数组
            Arrays.sort(nums);
            //遍历小于等于0的数
            for (int i = 0; i < nums.length; i++) {
                //重复元素不用再走一遍了
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                if (nums[i] > 0) {
                    break;
                }
                int sum = 0;
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> numList = new ArrayList<Integer>();
                        numList.add(nums[i]);
                        numList.add(nums[left]);
                        numList.add(nums[right]);
                        resultList.add(numList);
                        while (++left < right && nums[left] == nums[left - 1]) {

                        }
                        while (--right > left && nums[right] == nums[right + 1]) {

                        }
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return resultList;
        }
    }


    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum__(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        } else {
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] > 0) {
                    break;
                }

                int sum = 0;
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);

                        result.add(temp);
                        while (++left < right && nums[left] == nums[left - 1]) {

                        }

                        while (--right > left && nums[right] == nums[right + 1]) {

                        }
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
            return result;
        }
    }
}
