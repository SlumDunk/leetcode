package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Leetcode409 {
    public static void main(String[] args) {
        Leetcode409 leetcode409 = new Leetcode409();
        leetcode409.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
    }

    public int longestPalindrome(String s) {
        //最长的奇数字符放中间，其他奇数减1变偶数，和偶数两侧排开
        int count = 0;
        int maxOdd = 0;//记录当前最长的奇数个数字符
        int[] array = new int[60];
        for (char value : s.toCharArray()) {
            array[value - 'A']++;
        }
        //从大往小
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                count += array[i];
            } else {
                if (array[i] > maxOdd) {//新的字符子串放中间，旧的减一两侧排开
                    count += array[i];
                    if (maxOdd > 0) {
                        count += maxOdd - 1;
                    }
                    maxOdd = array[i];
                } else {
                    count += array[i] - 1;
                }
            }
        }
        return count;
    }


    /**
     * O(n)
     *
     * @param s
     * @return
     */
    public int longestPalindrome_(String s) {
        //最长的奇数字符放中间，其他奇数减1变偶数，和偶数两侧排开
        int result = 0;
        int maxOdd = 0;//记录当前最长的奇数个数字符
        int[] array = new int[60];
        for (char value : s.toCharArray()) {
            array[value - 'A']++;
        }

        for (int count : array) {
            if (count % 2 == 1) {
                maxOdd = Math.max(maxOdd, count);
            }
        }
        //从大往小
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                result += array[i];
            } else {
                if (array[i] == maxOdd) {
                    result += maxOdd;
                    maxOdd = Integer.MAX_VALUE;
                } else {
                    result += array[i] - 1;
                }
            }
        }
        return result;
    }
}
