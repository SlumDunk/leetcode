package com.github.leetcode.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class Leetcode541 {
    public static void main(String[] args) {
        Leetcode541 leetcode541 = new Leetcode541();
        leetcode541.reverseStr("abcdefg", 2);
    }

    public String reverseStr(String s, int k) {
        //2k个字符为一组，翻转前k个，后面的不变
        int len = s.length();
        //先将字符串转成数组
        char[] array = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            //注意数组边界
            int left = i, right = (i + k - 1) < len ? i + k - 1 : len - 1;
            while (left < right) {
                char tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(array);
    }


}
