package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 10:43
 * @Description: Given an input string , reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class Leetcode186 {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        //逐个单词内部进行翻转
        int r = 0;
        while (r < str.length) {
            int l = r;
            while (r < str.length && str[r] != ' ') {
                r++;
            }
            reverse(str, l, r - 1);
            r++;
        }
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }
}
