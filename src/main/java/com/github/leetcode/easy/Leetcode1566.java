package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 17:22
 * @Description: Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.
 * <p>
 * A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.
 * <p>
 * Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,4,4,4,4], m = 1, k = 3
 * Output: true
 * Explanation: The pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern can be repeated k or more times but not less.
 * Example 2:
 * <p>
 * Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * Output: true
 * Explanation: The pattern (1,2) of length 2 is repeated 2 consecutive times. Another valid pattern (2,1) is also repeated 2 times.
 * Example 3:
 * <p>
 * Input: arr = [1,2,1,2,1,3], m = 2, k = 3
 * Output: false
 * Explanation: The pattern (1,2) is of length 2 but is repeated only 2 times. There is no pattern of length 2 that is repeated 3 or more times.
 * Example 4:
 * <p>
 * Input: arr = [1,2,3,1,2], m = 2, k = 2
 * Output: false
 * Explanation: Notice that the pattern (1,2) exists twice but not consecutively, so it doesn't count.
 * Example 5:
 * <p>
 * Input: arr = [2,2,2,2], m = 2, k = 3
 * Output: false
 * Explanation: The only pattern of length 2 is (2,2) however it's repeated only twice. Notice that we do not count overlapping repetitions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 100
 * 1 <= arr[i] <= 100
 * 1 <= m <= 100
 * 2 <= k <= 100
 */
public class Leetcode1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        //if the total required length is greater than the length of the arr..we cannot make the pattern..return false
        if (m * k > n) return false;

        //take 2 pointers.. one at **0th** index and another **mth** index..and start searching for pattern
        int l = 0, r = m;
        int reqLen = 0;

        //if the chars are matching.. increase the length else make the reqLen=0;
        while (r < n) {
            if (arr[l] == arr[r])
                reqLen++;
            else
                reqLen = 0;

            //if we have the required pattern count..return true
            if (reqLen >= m * (k - 1)) return true;

            l++;
            r++;
        }
        return false;
    }
}
