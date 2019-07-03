package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 08:36
 * @Description: We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
 * <p>
 * Example 1:
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * Example 2:
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * Example 3:
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * Example 4:
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 * <p>
 * <p>
 * Note:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 */
public class Leetcode816 {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            List<String> res1 = helper(S.substring(0, i));
            List<String> res2 = helper(S.substring(i));
            if (res1.size() == 0 || res2.size() == 0) continue;
            for (String s1 : res1) {
                for (String s2 : res2) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return res;
    }

    /**
     * 字符串能被解析成的数字
     * 没有多余的0
     *
     * @param S
     * @return
     */
    private List<String> helper(String S) {
        List<String> res = new ArrayList();
        if (S.length() == 0) return res;
        //长度为1，或者是首位不为0且末尾为0 100
        if (S.length() == 1 || (S.charAt(0) != '0' && S.charAt(S.length() - 1) == '0')) {
            res.add(S);
            return res;
        }
        //0开头且末尾是0
        if (S.charAt(0) == '0' && S.charAt(S.length() - 1) == '0') return res;
        if (S.charAt(0) == '0') {//0开头的
            res.add(S.substring(0, 1) + "." + S.substring(1, S.length()));
            return res;
        }
        //非0开头，找中间点切割
        for (int i = 0; i < S.length() - 1; i++) {
            res.add(S.substring(0, i + 1) + "." + S.substring(i + 1, S.length()));
        }
        res.add(S);
        return res;
    }
}
