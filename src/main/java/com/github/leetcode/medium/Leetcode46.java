package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 13:27
 * @Description: Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 如果我们知道两个元素所有排列组合的结果，那么在该排列组合的结果上加入第三个元素，
 * 只需将第三个元素插入双元素排列组合结果的不同位置上即可以生成三个元素排列组合的结果。
 * 四个元素同理
 */
public class Leetcode46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        Leetcode46 leetcode46 = new Leetcode46();
        System.out.println(leetcode46.permute(nums));
    }


    public List<List<Integer>> permute(int[] nums) {
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
        //遍历数组，使用未被使用的数字
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
            }
        }
    }


    /**
     * O(n*n!)
     * 最后copy耗时n,总共有n!
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute__(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            helper(nums, result, temp);

            return result;
        }

    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                } else {
                    temp.add(nums[i]);
                    helper(nums, result, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
