package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 16:48
 * @Description: For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */
public class Leetcode1071 {
    public String gcdOfStrings(String str1, String str2) {
        return GCD(str1, str2);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private String GCD(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        if (a.equals(b)) {
            return a;
        }
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) != a.charAt(i)) {
                    return "";
                }
            }
            String temp = a.substring(b.length());
            return GCD(temp, b);
        } else if (b.length() > a.length()) {
            return GCD(b, a);
        } else {
            return "";
        }
    }
}
