package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 09:36
 * @Description: Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * <p>
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.
 * <p>
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
 * <p>
 * Given a list of query words, return the number of words that are stretchy.
 * <p>
 * <p>
 * <p>
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 */
public class Leetcode809 {
    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        int res = 0;
        for (String word :
                words) {
            if (check(S, word)) {
                res++;
            }
        }
        return res;
    }

    /**
     *
     * @param s
     * @param word
     * @return
     */
    private boolean check(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length()) {
            int count = 1, count2 = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            while (j < word.length() - 1 && word.charAt(j) == word.charAt(j + 1)) {
                count2++;
                j++;
            }
            if (j == word.length() || word.charAt(j) != s.charAt(i) || (count2 > count) || (count2 != count && count < 3))
                return false;
            i++;
            j++;
        }
        return j==word.length();
    }
}
