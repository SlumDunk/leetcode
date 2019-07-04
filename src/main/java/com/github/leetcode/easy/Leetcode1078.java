package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:04
 * @Description: Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 * <p>
 * For each such occurrence, add "third" to the answer, and return the answer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 * <p>
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class Leetcode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        //split input into array
        String[] textArr = text.split(" ");
        List<String> res = new ArrayList<>();

        //从后往前扫
        for (int i = textArr.length - 1; i > 0; i--) {

            if (textArr[i - 1].equals(second) && i > 1 && textArr[i - 2].equals(first))
                res.add(textArr[i]);
        }
        String[] ans = new String[res.size()];

        //convert list to arrays
        for (int i = 0, j = res.size() - 1; i < res.size(); i++, j--)
            ans[i] = res.get(j);

        return ans;
    }
}
