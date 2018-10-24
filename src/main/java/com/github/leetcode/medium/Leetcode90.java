package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 13:00
 * @Description: Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Leetcode90 {
    List<List<Integer>> res = new ArrayList<>();
    int[] num;
    int len;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        len = nums.length;
        num = nums;
        Arrays.sort(num);
        res.add(new ArrayList<>());
        sub(0, new ArrayList<>());
        return res;
    }

    public void sub(int start, List<Integer> ans) {
        int flag = 0;
        for (int i = start; i < len; i++) {
            if (i > 0 && flag == 1 && num[i] == num[i - 1])
                continue;
            ans.add(num[i]);
            flag = 1;
            res.add(new ArrayList<Integer>(ans));
            sub(i + 1, ans);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}
