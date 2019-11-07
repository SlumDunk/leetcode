package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 15:41
 * @Description: Given a string and an offset, rotate string by offset. (rotate from left to right)
 * <p>
 * Example
 * Given "abcdefg".
 * <p>
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * Challenge
 * Rotate in-place with O(1) extra memory.
 */
public class Lintcode8 {

    /**
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - 1 - offset);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }
    }


    /**
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString__(char[] str, int offset) {
        // write your code here
        if (offset == 0) {
            return;
        } else {
            int n = str.length;
            if (n == 0) {
                return;
            }
            offset = offset % n;
            //翻转左半部分
            rotate(str, 0, n - 1 - offset);
            //翻转右半部分
            rotate(str, n - offset, n - 1);
            //翻转整个串
            rotate(str, 0, n - 1);
        }
    }

    private void rotate(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }
    }
}
