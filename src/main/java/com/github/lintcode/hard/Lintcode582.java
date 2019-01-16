package com.github.lintcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 08:39
 * @Description: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * Example
 * Gieve s = lintcode,
 * dict = ["de", "ding", "co", "code", "lint"].
 * <p>
 * A solution is ["lint code", "lint co de"].
 */
public class Lintcode582 {
    /*
    * @param s: A string
    * @param wordDict: A set of words.
    * @return: All possible sentences.
    */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        } else {
            boolean[][] isWord = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String word = s.substring(i, j + 1);
                    isWord[i][j] = wordDict.contains(word);
                }
            }
            //i...len能否切割成字典中的单词
            boolean[] possible = new boolean[s.length() + 1];
            possible[s.length()] = true;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (isWord[i][j] && possible[j + 1]) {
                        possible[i] = true;
                        break;
                    }
                }
            }
            List<String> temp = new ArrayList<String>();
            helper(0, s, wordDict, temp, result, possible, isWord);
            return result;
        }
    }

    public void helper(int start, String s, Set<String> wordDict, List<String> temp, List<String> result, boolean[] possible, boolean[][] isWord) {
        if (!possible[start]) {
            return;
        }
        if (start == s.length()) {
            result.add(generateString(temp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (!isWord[start][i]) {
                    continue;
                }
                String pre = s.substring(start, i + 1);
                if (wordDict.contains(pre)) {
                    temp.add(pre);
                    helper(i + 1, s, wordDict, temp, result, possible, isWord);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public String generateString(List<String> list) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            buffer.append(list.get(i));
            if (i != list.size() - 1) {
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }
}
