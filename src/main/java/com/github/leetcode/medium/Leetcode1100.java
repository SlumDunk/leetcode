package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 14:55
 * @Description: 1100. Find K-Length Substrings With No Repeated Characters
 * Medium
 * <p>
 * 21
 * <p>
 * 2
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a string S, return the number of substrings of length K with no repeated characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 * <p>
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation:
 * Notice K can be larger than the length of S. In this case is not possible to find any substring.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 10^4
 * All characters of S are lowercase English letters.
 * 1 <= K <= 10^4
 */
public class Leetcode1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        HashSet<Character> cur = new HashSet<>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            //滑动窗口
            while (cur.contains(S.charAt(j)))
                cur.remove(S.charAt(i++));
            cur.add(S.charAt(j));
            int len = j - i + 1;
            if (len == K) {
                res++;
                cur.remove(S.charAt(i++));
            }
        }
        return res;
    }

    /**
     * O(n)
     *
     * @param S
     * @param K
     * @return
     */
    public int numKLenSubstrNoRepeats_(String S, int K) {
        //保证不出现重复
        List<Character> window = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < S.length(); ++i) {
            while (window.contains(S.charAt(i))) {
                window.remove(0);
            }
            window.add(S.charAt(i));
            if (window.size() == K) {
                res++;
                window.remove(window.remove(0));
            }
        }
        return res;
    }
}
