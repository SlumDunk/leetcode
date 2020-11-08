package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 19:25
 * @Description: Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Find the kth positive integer that is missing from this array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 * <p>
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
public class Leetcode1539 {
    public int findKthPositive(int[] arr, int k) {
        int start = 1; // smallest positve number
        int index = 0;
        boolean flag = false;
        while (k > 0) {
            if (index == arr.length) {
                flag = true;
                break;
            }
            if (arr[index] != start)
                k--;
            else
                index++;

            start++;
        }
        if (flag) {
            start += k - 1;
            return start;
        }
        return start - 1;
    }
}

