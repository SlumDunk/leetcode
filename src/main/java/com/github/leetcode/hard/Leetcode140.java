package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 21:41
 * @Description: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class Leetcode140 {
    /**
     * 用于存储从位置key开始，能组成的字符串
     */
    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        //深度遍历
        List<String> result = dfs(s, wordDict, 0);
        return result;
    }

    /**
     * 深度遍历
     *
     * @param s        字符串
     * @param wordDict 字典集合
     * @param start    开始位置
     * @return
     */
    private List<String> dfs(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {//从缓存里头取
            return map.get(start);
        } else {
            List<String> res = new ArrayList<>();
            if (start == s.length()) {
                res.add("");
            } else {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {//找到符合条件的单词
                        //深度遍历
                        List<String> list = dfs(s, wordDict, end);
                        for (String value :
                                list) {
                            res.add(s.substring(start, end) + (value.equals("") ? "" : " " + value));
                        }
                    }
                }
                map.put(start, res);
            }
            return res;
        }
    }
}
