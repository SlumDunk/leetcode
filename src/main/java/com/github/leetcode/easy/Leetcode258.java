package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/23/18 10:43
 * @Description: Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * <p>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class Leetcode258 {
    public int addDigits(int num) {
        //存储每一次循环的结果
        int sum = 0;
        while (num > 0 || sum >= 10) {
            if (num == 0) {//本次循环数字的位数已经走完了
                num = sum;
                sum = 0;
            } else {
                sum += num % 10;
                num /= 10;
            }
        }
        return sum;

    }
}
