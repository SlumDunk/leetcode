package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 22:24
 * @Description: S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * <p>
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of T (as a string) that satisfies this property.
 * <p>
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 * <p>
 * <p>
 * Note:
 * <p>
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
public class Leetcode791 {
    public String customSortString(String S, String T) {
        char[] sCharAry = S.toCharArray();
        char[] tCharAry = T.toCharArray();

        //双向map
        HashMap<Character, Integer> cToIMap = new HashMap<>();
        HashMap<Integer, Character> iToCMap = new HashMap<>();

        for (int i = 0; i < sCharAry.length; ++i) {
            char c = sCharAry[i];
            int v = i * 1000 + 1000000;
            cToIMap.put(c, v);
            iToCMap.put(v, c);
        }

        int[] tIntAry = new int[tCharAry.length];
        for (int i = 0; i < tCharAry.length; ++i) {
            char c = tCharAry[i];
            int v = c;
            if (cToIMap.containsKey(c)) {
                v = cToIMap.get(c);
            }
            tIntAry[i] = v;
        }
        //排序
        Arrays.sort(tIntAry);

        char[] retAry = new char[tCharAry.length];
        for (int i = 0; i < tCharAry.length; ++i) {
            int v = tIntAry[i];
            char c;
            if (iToCMap.containsKey(v)) {
                c = iToCMap.get(v);
            } else {
                c = (char) v;
            }
            retAry[i] = c;
        }

        return new String(retAry);
    }
}
