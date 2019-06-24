package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 15:22
 * @Description: Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
 * <p>
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 * Example 2:
 * <p>
 * Input: [1,1,1]
 * Output: [false,false,false]
 * Example 3:
 * <p>
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 * Example 4:
 * <p>
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 */
public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0, units = 0; i < A.length; i++) {
            units *= 2;
            units += A[i];
            ans.add(units % 5 == 0 ? true : false);
            units %= 10;
        }

        return ans;
    }
}
