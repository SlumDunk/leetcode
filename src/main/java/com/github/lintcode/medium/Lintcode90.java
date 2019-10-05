package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/5/19 10:41
 * @Description:
 */
public class Lintcode90 {
    int target;

    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(A);
        this.target = target;
        helper(A, 0, k, 0, temp, resultList);
        return resultList;
    }


    /**
     * @param A          数组
     * @param start      开始位置
     * @param positions  剩下空位数
     * @param sum        当前和
     * @param temp       临时list
     * @param resultList 结果list
     */
    public void helper(int[] A, int start, int positions, int sum, List<Integer> temp, List<List<Integer>> resultList) {
        if (sum == this.target && positions == 0) {
            resultList.add(new ArrayList<Integer>(temp));
        } else {
            if (positions == 0) {
                return;
            } else {
                for (int i = start; i < A.length; i++) {
                    if (sum + A[i] > target) {
                        break;
                    }
                    temp.add(A[i]);
                    helper(A, i + 1, positions - 1, sum + A[i], temp, resultList);
                    temp.remove(temp.size() - 1);
                }

                return;
            }
        }
    }
}
