package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 08:21
 * @Description: Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
 * <p>
 * Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 * <p>
 * Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * Output: [1,0,0,0,0]
 * Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 and arr2 have no leading zeros
 * arr1[i] is 0 or 1
 * arr2[i] is 0 or 1
 */
public class Leetcode1073 {

    /**
     * 1 1 1 1 1
     * 1 0 1
     * 2
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return arr2;
        if (arr2 == null || arr2.length == 0) return arr1;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        //从低位到高位
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += arr1[i--];
            }
            if (j >= 0) {
                carry += arr2[j--];
            }
            int remainder = carry % (-2);
            carry = carry / (-2);
            if (remainder < 0) {
                remainder += 2;
                carry++;
            }
            res.add(remainder);
        }
        //remove duplicate 0s
        for (int k = res.size() - 1; k >= 1; k--) {
            if (res.get(k) == 0) {
                res.remove(k);
            } else {
                break;
            }
        }

        int[] result = new int[res.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = res.get(res.size() - 1 - k);
        }
        return result;
    }
}
