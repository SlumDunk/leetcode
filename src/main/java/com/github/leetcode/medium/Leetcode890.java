package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 21:22
 * @Description: You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 * <p>
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 * <p>
 * Return a list of the words in words that match the given pattern.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class Leetcode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList();
        if (words == null || words.length == 0 || pattern == null)
            return result;

        String patternPat = getPatternStr(pattern);
        for (String word : words) {
            String wordPat = getPatternStr(word);
            if (wordPat.equals(patternPat))
                result.add(word);
        }
        return result;
    }

    /**
     * 返回字符串对应的模式 由字符首次出现的位置数字组成
     *
     * @param word
     * @return
     */
    private String getPatternStr(String word) {
        Map<Character, String> map = new HashMap<Character, String>();
        StringBuilder sb = new StringBuilder();
        String l = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c) && i != 0) {
                l = map.get(c);
            } else {
                l = i + "";
                map.put(c, l);
            }
            sb.append(l);
        }
        String pat = sb.toString();
        return pat;
    }
}
