package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 22:11
 * @Description: Given a string which contains only letters. Sort it by lower case first and upper case second.
 * <p>
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 * <p>
 * Challenge
 * Do it in one-pass and in-place.
 * <p>
 * Notice
 * It's NOT necessary to keep the original order of lower-case letters and upper case letters.
 */
public class Lintcode49 {
    /*
   * @param chars: The letter array you should sort by Case
   * @return: nothing
   */
    public void sortLetters(char[] chars) {
        // write your code here
        int len = chars.length;
        int i = 0, j = len - 1;
        while (i < j) {
            while (i < len && Character.isLowerCase(chars[i])) {
                i++;
            }
            while (j >= 0 && Character.isUpperCase(chars[j])) {
                j--;
            }
            if (i < j) {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                i++;
                j--;
            } else {
                break;
            }
        }
    }
}
