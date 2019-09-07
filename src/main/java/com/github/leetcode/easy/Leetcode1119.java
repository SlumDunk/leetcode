package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 09:54
 * @Description: Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * Example 2:
 * <p>
 * Input: "aeiou"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * S consists of lowercase English letters only.
 * 1 <= S.length <= 1000
 */
public class Leetcode1119 {
    String voewls = "aeiou";

    public String removeVowels(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder buffer = new StringBuilder();
        for (char c :
                S.toCharArray()) {
            if (!isVowel(c)) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 判断字符是不是元音字符
     *
     * @param c
     * @return
     */
    private boolean isVowel(char c) {
        if (voewls.indexOf(c) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
