package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 10/7/19 10:45
 * @Description: 1790. Rotate String II
 * 中文English
 * Given a string(Given in the way of char array), a right offset and a left offset, rotate the string by offset in place.(left offest represents the offset of a string to the left,right offest represents the offset of a string to the right,the total offset is calculated from the left offset and the right offset,split two strings at the total offset and swap positions)。
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input：str ="abcdefg", left = 3, right = 1
 * Output："cdefgab"
 * Explanation：The left offset is 3, the right offset is 1, and the total offset is left 2. Therefore, the original string moves to the left and becomes "cdefg"+ "ab".
 * Example 2:
 * <p>
 * Input：str="abcdefg", left = 0, right = 0
 * Output："abcdefg"
 * Explanation：The left offset is 0, the right offset is 0, and the total offset is 0. So the string remains unchanged.
 * Example 3:
 * <p>
 * Input：str = "abcdefg",left = 1, right = 2
 * Output："gabcdef"
 * Explanation：The left offset is 1, the right offset is 2, and the total offset is right 1. Therefore, the original string moves to the left and becomes "g" + "abcdef".
 */
public class Lintcode1790 {
    /**
     * @param str:   An array of char
     * @param left:  a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        if (left - right == 0) {
            return str;
        } else {
            int n = str.length();
            char[] array = str.toCharArray();
            left = left % n;
            right = right % n;

            if (left > right) {
                int offset = left - right;
                rotate(array, 0, offset - 1);
                rotate(array, offset, n - 1);
                rotate(array, 0, n - 1);

            } else {
                int offset = right - left;
                rotate(array, 0, n - 1 - offset);
                rotate(array, n - offset, n - 1);
                rotate(array, 0, n - 1);
            }
            return new String(array);
        }
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
