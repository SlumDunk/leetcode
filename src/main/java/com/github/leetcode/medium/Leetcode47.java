package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/14/18 16:53
 * @Description: Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Leetcode47 {
    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(leetcode47.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        getResult(result, nums, new ArrayList<Integer>(), 0, new int[nums.length]);
        return result;
    }

    public static void getResult(List<List<Integer>> result, int[] nums, List<Integer> ans, int num, int[] pos) {
        if (num == nums.length) {
            result.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (pos[i] == 0) {
                ans.add(nums[i]);
                pos[i] = 1;
                getResult(result, nums, ans, num + 1, pos);
                pos[i] = 0;
                ans.remove(num);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {//在这里判断之后的数字是否一样，如果一样，就直接跳过。
                    i++;
                }
            }
        }
    }


}
