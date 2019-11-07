package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/24/18 22:33
 * @Description: Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class Leetcode345 {
    public String reverseVowels(String s) {
        //双指针
        //元音字符串
        String vowels = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();

        while (left < right) {
            //找到左侧元音字母
            while (left < right && !vowels.contains(array[left] + "")) {
                left++;
            }
            //找到右侧元音字母
            while (left < right && !vowels.contains(array[right] + "")) {
                right--;
            }
            //交换位置
            if (left < right) {
                char c = array[left];
                array[left++] = array[right];
                array[right--] = c;
            }
        }
        return new String(array);
    }

    public String reverseVowels_(String s) {
        //双指针
        //元音字符串
        String vowels = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();

        while (left < right) {
            //找到左侧元音字母
            while (left < right && !vowels.contains(array[left] + "")) {
                left++;
            }
            //找到右侧元音字母
            while (left < right && !vowels.contains(array[right] + "")) {
                right--;
            }
            //交换位置
            if (left < right) {
                if (array[left] != array[right]) {
                    char c = array[left];
                    array[left] = array[right];
                    array[right] = c;
                }
                left++;
                right--;
            }
        }
        return new String(array);
    }
}
