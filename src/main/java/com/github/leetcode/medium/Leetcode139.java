package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 22:24
 * @Description: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //dp[i]表示前i个字符能不能被dict完美划分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++)
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                //能否组合出f[i]表示的子串，k表示组合中前半段的
                if (dp[j] && wordDict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        return dp[len];
    }
}
