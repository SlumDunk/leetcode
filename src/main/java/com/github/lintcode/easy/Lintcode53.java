package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 20:46
 * @Description: Given an input string, reverse the string word by word.
 * <p>
 * Example
 * Given s = "the sky is blue",
 * <p>
 * return "blue is sky the".
 * <p>
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class Lintcode53 {
    /*
    * @param s: A string
    * @return: A string
    */
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder buffer = new StringBuilder("");
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                if (buffer.length() > 0) {
                    buffer.append(" ");
                }
            }
            buffer.append(array[i]);
        }
        return buffer.toString();
    }
}
