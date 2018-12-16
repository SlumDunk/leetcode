package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 11:36
 * @Description: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 */
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>();
        if (rowIndex == 0) {
            resultList.add(1);
        } else if (rowIndex == 1) {
            resultList.add(1);
            resultList.add(1);
        } else {
            for (int i = 0; i < rowIndex + 1; i++) {
                //每次在上一次结果的基础上往头部塞入1
                resultList.add(0, 1);
                for (int j = 1; j < resultList.size() - 1; j++) {
                    //1，1，2，1->1,3,3,1
                    resultList.set(j, resultList.get(j) + resultList.get(j + 1));
                }
            }
        }
        return resultList;
    }
}
