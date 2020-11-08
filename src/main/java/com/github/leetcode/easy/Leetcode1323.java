package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/2/20 20:45
 * @Description: Given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 * <p>
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 * <p>
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 */
public class Leetcode1323 {
    public static void main(String[] args) {
        Leetcode1323 leetcode1323 = new Leetcode1323();
        leetcode1323.maximum69Number(9669);
    }

    public int maximum69Number(int num) {
        List<Integer> numList = new ArrayList<>();
        while (num > 0) {
            numList.add(num % 10);
            num = num / 10;
        }

        int sum = 0;
        boolean flag = false;
        for (int i = numList.size() - 1; i >= 0; i--) {
            if (numList.get(i) == 6 && !flag) {
                sum += Math.pow(10, i) * 9;
                flag = !flag;
            } else {
                sum += Math.pow(10, i) * numList.get(i);
            }
        }
        return sum;
    }
}
