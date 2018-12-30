package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/28/18 10:18
 * @Description: Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class Leetcode318 {
    public static void main(String[] args) {
        Leetcode318 leetcode318 = new Leetcode318();
        leetcode318.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] num = new int[len];
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (char value : words[i].toCharArray()) {
                //每个单词根据其字符可以生成唯一的二进制串
                num[i] |= (1 << (value - 'a'));
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //两个字符串的二进制签名没有交集证明他们没有共同的字符
                if ((num[i] & num[j]) == 0) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);

                }
            }
        }
        return maxProduct;
    }
}
