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
        //对数组进行排序
        Arrays.sort(nums);
        getResult(result, nums, new ArrayList<Integer>(), 0, new int[nums.length]);
        return result;
    }

    /**
     * @param result 结果集
     * @param nums   候选数字
     * @param ans    缓存结果
     * @param num    当前数组长度
     * @param pos    数组中各数字标记，1为被使用，0为未被使用
     */
    public static void getResult(List<List<Integer>> result, int[] nums, List<Integer> ans, int num, int[] pos) {
        //结果list长度和数组长度一致，添加到结果集
        if (num == nums.length) {
            result.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //该数字未被使用
            if (pos[i] == 0) {
                //添加到中间结果
                ans.add(nums[i]);
                //置为使用
                pos[i] = 1;
                //继续获取结果
                getResult(result, nums, ans, num + 1, pos);
                //复位
                pos[i] = 0;
                //从暂存list中移除
                ans.remove(num);
                //当前层次相同的元素跳过，因为会得到相同的结果集
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }


}
