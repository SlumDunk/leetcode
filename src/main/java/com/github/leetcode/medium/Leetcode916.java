package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 16:40
 * @Description: We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * <p>
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * <p>
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * <p>
 * Return a list of all universal words in A.  You can return the words in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 * <p>
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * Example 3:
 * <p>
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * Example 4:
 * <p>
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 * Example 5:
 * <p>
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 */
public class Leetcode916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        //保存B中各个字符的最大出现次数
        int[] maxWordCnt = new int[26];
        List<String> list = new ArrayList<>();
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; i++) {
                maxWordCnt[i] = Math.max(maxWordCnt[i], bCount[i]);
            }
        }

        for (String a : A) {
            int[] aCount = count(a);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] < maxWordCnt[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(a);
        }
        return list;
    }

    /**
     * 计算单词各个字符出现的频率
     *
     * @param word
     * @return
     */
    private int[] count(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        return arr;
    }
}
