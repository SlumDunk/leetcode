package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 21:38
 * @Description: You are given an array A of strings.
 * <p>
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * <p>
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * <p>
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 * <p>
 * Return the number of groups of special-equivalent strings from A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 * Example 2:
 * <p>
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 * Example 3:
 * <p>
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * Example 4:
 * <p>
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */
public class Leetcode893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int[] a = new int[52];
            String item = A[i];
            int subLen = item.length();
            for (int j = 0; j < subLen; j++) {
                a[item.charAt(j) - 'a' + 26 * (j % 2)]++;
            }
            set.add(Arrays.toString(a));
        }
        return set.size();
    }
}
