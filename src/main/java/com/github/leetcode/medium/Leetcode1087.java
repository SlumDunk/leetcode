package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 18:12
 * @Description: A string S represents a list of words.
 * <p>
 * Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].
 * <p>
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 * <p>
 * Return all words that can be formed in this manner, in lexicographical order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: ["abcd"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 50
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly brackets are different.
 */
public class Leetcode1087 {
    public String[] expand(String S) {
        //存储每一层的字符
        List<List<Character>> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        int i = 0;
        while (i < chars.length) {    // Convert String input to Lists for each level
            if (chars[i] == '{') {
                List<Character> curt = new ArrayList<>();
                i++;
                while (i < chars.length && chars[i] != '}') {
                    if (chars[i] != ',') curt.add(chars[i]);
                    i++;
                }
                list.add(curt);
                i++;
            } else if (i < chars.length) {
                List<Character> curt = new ArrayList<>();
                curt.add(chars[i++]);
                list.add(curt);
            }
        }

        List<String> res = new ArrayList<>();
        dfs(list, 0, new StringBuilder(), res);
        String[] result = new String[res.size()];    // Dumb way to convert list to array
        for (int j = 0; j < result.length; j++) {
            result[j] = res.get(j);
        }
        Arrays.sort(result);    // sort array for Lexicographical order
        return result;
    }

    /**
     * @param list
     * @param level
     * @param sb    拼成的字符串
     * @param res   结果List
     */
    private void dfs(List<List<Character>> list, int level, StringBuilder sb, List<String> res) {
        if (level == list.size()) {     // when completed traversing all levels, add String to res
            res.add(sb.toString());
            return;
        }
        for (char s : list.get(level)) {
            sb.append(s);
            dfs(list, level + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
