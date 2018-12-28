package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 21:10
 * @Description: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backTrack(res, temp, n, k, 1);
        return res;
    }

    /**
     * @param res  结果集
     * @param temp 中间结果
     * @param end    取值范围
     * @param number    剩余数字数量
     * @param start    开始的数字
     */
    private void backTrack(List<List<Integer>> res, List<Integer> temp, int end, int number, int start) {
        //找到长度为k的结果了
        if (number == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            //添加到中间结果
            temp.add(i);
            //往前走
            backTrack(res, temp, end, number - 1, i + 1);
            //回溯删除移除数字
            temp.remove(temp.size() - 1);
        }
    }

}
