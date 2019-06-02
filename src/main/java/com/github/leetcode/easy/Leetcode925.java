package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 10:35
 * @Description: Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * <p>
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * <p>
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * <p>
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * <p>
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * <p>
 * <p>
 * Note:
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class Leetcode925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] c1 = name.toCharArray();
        char[] c2 = typed.toCharArray();

        int i = 0, j = 0;
        while (i < c1.length - 1 && j < c2.length) {
            if (c1[i] != c2[j]) {
                return false;
            }
            if (c1[i] != c1[i + 1]) {
                while (j < c2.length - 1 && c2[j] == c2[j + 1]) {
                    j++;
                }
            }
            i++;
            j++;
        }
        return c1[c1.length - 1] == c2[c2.length - 1];
    }
}
