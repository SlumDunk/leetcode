package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 11:16
 * @Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Leetcode118 {
    public static void main(String[] args) {
        Leetcode118 leetcode118 = new Leetcode118();
        leetcode118.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        } else {
            List<List<Integer>> resultList = new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                if (i == 0) {
                    resultList.add(new ArrayList<>());
                    resultList.get(i).add(1);
                } else if (i == 1) {
                    resultList.add(new ArrayList<>());
                    resultList.get(i).add(1);
                    resultList.get(i).add(1);
                } else {
                    List<Integer> tmpList = new ArrayList<>(i + 1);
                    tmpList.add(0, 1);
                    for (int j = 1; j < i; j++) {
                        tmpList.add(j, resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j));
                    }
                    tmpList.add(tmpList.size(), 1);
                    resultList.add(tmpList);
                }
            }
            return resultList;
        }

    }
}
