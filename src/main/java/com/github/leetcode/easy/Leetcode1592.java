package com.github.leetcode.easy;

import java.util.Collections;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 16:46
 * @Description: You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.
 * <p>
 * Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.
 * <p>
 * Return the string after rearranging the spaces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "  this   is  a sentence "
 * Output: "this   is   a   sentence"
 * Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
 * Example 2:
 * <p>
 * Input: text = " practice   makes   perfect"
 * Output: "practice   makes   perfect "
 * Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 * Example 3:
 * <p>
 * Input: text = "hello   world"
 * Output: "hello   world"
 * Example 4:
 * <p>
 * Input: text = "  walks  udp package   into  bar a"
 * Output: "walks  udp  package  into  bar  a "
 * Example 5:
 * <p>
 * Input: text = "a"
 * Output: "a"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 100
 * text consists of lowercase English letters and ' '.
 * text contains at least one word.
 */
public class Leetcode1592 {
    public String reorderSpaces(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        text = text.trim();
        String[] arr = text.split("\\s+");
        StringBuilder res = new StringBuilder("");
        if (arr.length > 1) {
            int len = arr.length;
            int middle = (count / (len - 1));   //of arr.length ==1 it will throw error hence if(arr.length>1)
            int rem = count % (len - 1);
            res.append(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                res.append(String.join("", Collections.nCopies(middle, " "))).append(arr[i]);
            }

            if (rem != 0) {
                res.append(String.join("", Collections.nCopies(rem, " ")));
            }

            return res.toString();
        } else //if only one word.
        {
            text = text.trim();
            res.append(text).append(String.join("", Collections.nCopies(count, " ")));
            return res.toString();
        }
    }
}
