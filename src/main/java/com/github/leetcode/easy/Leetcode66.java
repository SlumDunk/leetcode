package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/13/18 12:22
 * @Description: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        } else {
            int add = 0;
            int sum = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == digits.length - 1) {
                    sum = digits[i] + 1 + add;
                } else {
                    sum = digits[i] + add;
                }
                digits[i] = sum % 10;
                add = sum / 10;
                if (add == 0) {
                    break;
                }
            }
            if (add > 0) {//最终有进位
                int[] result = new int[digits.length + 1];
                result[0] = add;
                System.arraycopy(digits, 0, result, 1, digits.length);
                return result;
            } else {
                return digits;
            }
        }
    }
}
