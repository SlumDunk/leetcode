package com.github.leetcode.easy;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 */
public class Leetcode405 {
    public static void main(String[] args) {
        Leetcode405 leetcode405 = new Leetcode405();
        leetcode405.toHex(-1);
        System.out.println(Integer.toBinaryString(-1));
    }

    public String toHex(int num) {
        //小于10，直接返回
        if (num >= 0 && num < 10) {
            return Integer.toString(num);
        } else {
            //十六进制和数字映射关系
            char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder result = new StringBuilder();
            while (num != 0) {
                result.insert(0, hex[num & 0xf]);
                //注意>>和>>>的区别，前者高位会用符号位补全
                num = num >>> 4;
            }
            return result.toString();
        }
    }
}
