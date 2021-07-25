package com.github.leetcode.hard;

/**
 * Given a list of words, list of  single letters (might be repeating) and score of every character.
 * <p>
 * Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
 * <p>
 * It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * Output: 23
 * Explanation:
 * Score  a=1, c=9, d=5, g=3, o=2
 * Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
 * Words "dad" and "dog" only get a score of 21.
 * Example 2:
 * <p>
 * Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
 * Output: 27
 * Explanation:
 * Score  a=4, b=4, c=4, x=5, z=10
 * Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
 * Word "xxxz" only get a score of 25.
 * Example 3:
 * <p>
 * Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
 * Output: 0
 * Explanation:
 * Letter "e" can only be used once.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length == 26
 * 0 <= score[i] <= 10
 * words[i], letters[i] contains only lower case English letters.
 */
public class Leetcode1255 {
    int ans = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0)
            return 0;
        int[] count = new int[score.length];
        for (char ch : letters) {
            count[ch - 'a']++;
        }
        helper(words, count, score, 0, 0);
        return ans;
    }

    private void helper(String[] words, int[] count, int[] score, int index, int cur) {
        if (cur > ans) {
            ans = cur;
        }
        for (int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']--;
                res += score[ch - 'a'];
                if (count[ch - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                helper(words, count, score, i + 1, cur + res);
            }
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
            }
        }
    }
}
