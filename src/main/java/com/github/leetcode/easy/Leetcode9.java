package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 16:01
 * @Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        //把数字翻转一遍，如果和原来的一致，返回true
        if (x < 0) {
            return false;
        } else {
            int xCopy = x;
            int result = 0;
            while (x > 0) {
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return xCopy == result;
        }
    }
}
