package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 20:33
 * @Description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
public class Leetcode168 {
    public String convertToTitle(int n) {
        //26进制
        StringBuilder buffer = new StringBuilder("");
        while (n > 0) {
            //求出低位
            int x = n % 26;
            if (x > 0) {
                buffer.append((char) (x - 1 + 'A'));
            } else {
                buffer.append('Z');
                //防止下一步多出个A
                n--;
            }
            n = n / 26;
        }
        return buffer.reverse().toString();
    }
}
