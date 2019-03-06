package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 16:06
 * @Description: Write a function to generate the generalized abbreviations of a word.
 * <p>
 * Note: The order of the output does not matter.
 * <p>
 * Example:
 * <p>
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class Leetcode320 {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(result, word, 0, "", 0);
        return result;
    }

    private void helper(List<String> result, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            result.add(cur);
        } else {
            //跟前面字符连一起统计
            helper(result, word, pos + 1, cur, count + 1);
            //不连在一起统计
            helper(result, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
}
