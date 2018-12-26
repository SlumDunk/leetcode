package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/24/18 22:30
 * @Description: Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class Leetcode344 {
    public String reverseString(String s) {
        //利用StringBuilder拼接，然后翻转
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
        }
        return buffer.reverse().toString();
    }
}
