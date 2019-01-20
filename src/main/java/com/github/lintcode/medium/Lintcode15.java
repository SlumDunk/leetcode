package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 10:56
 * @Description: Given a list of numbers, return all possible permutations.
 * <p>
 * Example
 * For nums = [1,2,3], the permutations are:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Challenge
 * Do it without recursion.
 * <p>
 * Notice
 * You can assume that there is no duplicate numbers in the list.
 */
public class Lintcode15 {
    /*
    * @param nums: A list of integers.
    * @return: A list of permutations.
    */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            boolean[] visit = new boolean[nums.length];
            helper(nums, temp, result, visit);
            return result;
        }
    }

    private void helper(int[] nums, List<Integer> temp, List<List<Integer>> result, boolean[] visit) {
        if (nums.length == temp.size()) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visit[i] == true) {
                    continue;
                }
                temp.add(nums[i]);
                visit[i] = true;
                helper(nums, temp, result, visit);
                temp.remove(temp.size() - 1);
                visit[i] = false;
            }
        }
    }
}
