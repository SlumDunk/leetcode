package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 16:59
 * @Description: We are given that the string "abc" is valid.
 * <p>
 * From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
 * <p>
 * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 * <p>
 * Return true if and only if the given string S is valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 * Example 2:
 * <p>
 * Input: "abcabcababcc"
 * Output: true
 * Explanation:
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
 * Example 3:
 * <p>
 * Input: "abccba"
 * Output: false
 * Example 4:
 * <p>
 * Input: "cababc"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S[i] is 'a', 'b', or 'c'
 */
public class Leetcode1003 {
    public boolean isValid(String S) {
        int i = S.indexOf("abc");//寻找第一个abc；因为已超过
        //消去abc的方法
        while (i >= 0) {
            if (i == 0) {
                S = S.substring(3);
            } else {
                S = S.substring(0, i) + S.substring(i + 3);
            }
            i = S.indexOf("abc");
        }
        if (S.equals("")) {
            return true;
        }
        return false;
    }
}
