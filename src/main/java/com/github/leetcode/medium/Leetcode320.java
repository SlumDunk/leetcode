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

    /**
     * O(2^n)
     * @param word
     * @return
     */
    public List<String> generateAbbreviations__(String word) {
        List<String> result = new ArrayList<>();
        if (word == null || word.length() == 0) {
            result.add("");
            return result;
        } else {
            int len = word.length();
            String prev = "";
            helper(word, result, prev, 0, 0);
            return result;
        }
    }

    public void helper(String word, List<String> result, String prev, int position, int count) {
        if (position == word.length()) {
            String countStr = count > 0 ? String.valueOf(count) : "";
            result.add(prev + countStr);
        } else {
            //和前面的合在一起
            helper(word, result, prev, position + 1, count + 1);

            String countStr = count > 0 ? String.valueOf(count) : "";
            //和前面的不合在一起
            helper(word, result, prev + countStr + word.charAt(position), position + 1, 0);
        }
    }
}
