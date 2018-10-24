package com.github.leetcode.medium;

import java.util.ArrayList;
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
        System.out.println(leetcode46.permute2(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> first = new LinkedList<Integer>();
        first.add(0, nums[0]);
        result.add(first);
        List<Integer> temp;
        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            do {
                temp = result.removeFirst();
                for (int j = 0; j <= temp.size(); j++) {
                    temp.add(j, number);
                    result.add(new LinkedList<Integer>(temp));
                    temp.remove(j);
                }
            } while (result.getFirst().size() == i);
        }
        return result;
    }

    public List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> visitedList = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        getResult(result, nums, new ArrayList<Integer>(), 0, visitedList);
        return result;
    }

    public static void getResult(List<List<Integer>> result, int[] nums, ArrayList<Integer> ans, int num, List<Integer> visitedList) {
        if (num == nums.length) {
            result.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visitedList.contains(i)) {
                visitedList.add(i);
                ans.add(nums[i]);
                getResult(result, nums, ans, num + 1, visitedList);
                visitedList.remove((Integer) i);
                ans.remove((Integer) nums[i]);
            }
        }
    }
}
