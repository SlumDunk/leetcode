package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:03
 * @Description: Given a sentence that consists of some words separated by a single space, and a searchWord.
 * <p>
 * You have to check if searchWord is a prefix of any word in sentence.
 * <p>
 * Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).
 * <p>
 * If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 * <p>
 * A prefix of a string S is any leading contiguous substring of S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 * Example 2:
 * <p>
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 * Example 3:
 * <p>
 * Input: sentence = "i am tired", searchWord = "you"
 * Output: -1
 * Explanation: "you" is not a prefix of any word in the sentence.
 * Example 4:
 * <p>
 * Input: sentence = "i use triple pillow", searchWord = "pill"
 * Output: 4
 * Example 5:
 * <p>
 * Input: sentence = "hello from the other side", searchWord = "they"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence consists of lowercase English letters and spaces.
 * searchWord consists of lowercase English letters.
 */
public class Leetcode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
