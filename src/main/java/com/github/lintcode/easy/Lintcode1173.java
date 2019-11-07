package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 10/7/19 11:58
 * @Description: Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Notice
 * In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Lintcode1173 {
    /**
     * @param s: a string
     * @return: reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order
     */
    public String reverseWords(String s) {
        // write your code here
        //先挨个单词翻转
        int n = s.length();
        char[] array = s.toCharArray();
        int fromIndex = 0;
        int endIndex = -1;

        // how are you?
        // woh era ?uoy
        while ((endIndex = s.indexOf(" ", fromIndex)) != -1) {
            rotate(array, fromIndex, endIndex - 1);
            fromIndex = endIndex + 1;
        }
        //翻转最后一个单词
        rotate(array, fromIndex, n - 1);

        return new String(array);
    }

    private void rotate(char[] array, int start, int end) {
        char temp;

        while (start < end) {
            temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }
}
