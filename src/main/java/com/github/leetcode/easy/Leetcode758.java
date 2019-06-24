package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 16:19
 * @Description: Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 * <p>
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 * <p>
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 * <p>
 * Note:
 * <p>
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 */
public class Leetcode758 {
    public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0 || S == null) {
            return "";
        }
        int len = S.length();
        boolean[] flag = new boolean[len];
        for (String word : words) {
            int index = 0;
            while (index < len) {
                int start = S.indexOf(word, index);
                if (start != -1) {
                    for (int i = start; i < start + word.length(); i++) {
                        flag[i] = true;
                    }
                    index = start + 1;
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if ((i == 0 || flag[i - 1] == false) && flag[i] == true) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if ((i == len - 1 || flag[i + 1] == false) && flag[i] == true) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
