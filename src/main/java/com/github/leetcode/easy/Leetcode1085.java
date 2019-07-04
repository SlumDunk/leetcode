package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:23
 * @Description: Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.
 * <p>
 * Return 0 if S is odd, otherwise return 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [34,23,1,24,75,33,54,8]
 * Output: 0
 * Explanation:
 * The minimal element is 1, and the sum of those digits is S = 1 which is odd, so the answer is 0.
 * Example 2:
 * <p>
 * Input: [99,77,33,66,55]
 * Output: 1
 * Explanation:
 * The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which is even, so the answer is 1.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 */
public class Leetcode1085 {
    public int sumOfDigits(int[] A) {
        //find minimal
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i : A) {
            if (i < min) {
                min = i;
            }
        }
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        if (sum % 2 != 0)
            return 0;
        else
            return 1;
    }
}
