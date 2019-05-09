package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 15:46
 * @Description: Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical frequency.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero frequency is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical frequency is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class Leetcode8 {
    public int myAtoi(String str) {
        //找到数字的开始位置，注意数字的正负，数字是否越界
        int result = 0;
        //是否越界
        boolean overflow = false;
        //数字正负
        int sign = 1;
        //字符下标
        int index = 0;
        int len = str.length();
        //跳过特殊字符,找到第一个正常字符开始的位置
        while (index < len && (str.charAt(index) == ' ' || str.charAt(index) == '\n' || str.charAt(index) == '\t')) {
            index++;
        }
        if (index == len) {
            return 0;
        } else if (str.charAt(index) == '-') {//负数
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {//正数
            index++;
        }

        while (index < len) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            //判断数字是否越界
            if ((Integer.MAX_VALUE - (str.charAt(index) - '0')) / 10 < result) {
                overflow = true;
                break;
            }
            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }
        if (overflow) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return result * sign;
        }
    }

}
