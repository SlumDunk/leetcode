package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 11:36
 * @Description: Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class Leetcode1047 {
    public String removeDuplicates(String S) {
        String[] pattern = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
        while (returnPattern(S, pattern) != null) {
            String pat = returnPattern(S, pattern);
            S = S.replaceAll(pat, "");
        }
        return S;
    }

    public String returnPattern(String S, String[] pattern) {
        for (String pat : pattern) {
            if (S.contains(pat)) {
                return pat;
            }
        }
        return null;
    }
}
