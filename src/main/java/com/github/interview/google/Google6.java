package com.github.interview.google;

/**
 * @Author: zerongliu
 * @Date: 12/5/18 10:41
 * @Description: Write a function:
 * class Solution
 * {
 * public int solution(String S, String T) {}
 * }
 * <p>
 * <p>
 * that, given a string S and a string T, return 1 if it's possible to convert string S into string T by deleting some(possible zero)
 * characters from string S, and otherwise returns 0.
 * <p>
 * <p>
 * For example, given S="abcd" and T="abd" the function should return 1. We can delete 'c' from string S to convert string S into
 * string T. However, given S="ab" and T="ba" the function should return 0.
 * <p>
 * <p>
 * Assume that:
 * the length of ('S' , 'T') is within the range [1..1,000]
 * strings S and T consist only of lower-case letters (a-z).
 */
public class Google6 {
    public static void main(String[] args) {
        String strS = "abcd";
        String strT = "abd";
        Boolean result = canTransfrom(strS, strT);
    }

    /**
     * 查找T字符串是否是S字符串的最长公共子序列即可
     *
     * @param strS
     * @param strT
     * @return
     */
    private static Boolean canTransfrom(String strS, String strT) {
        int sLen = strS.length();
        int tLen = strT.length();
        if (sLen < tLen) {
            return Boolean.FALSE;
        } else {
            int[][] middle = new int[sLen + 1][tLen + 1];
            for (int i = 0; i < sLen + 1; i++) {
                middle[i][0] = 0;
            }
            for (int i = 0; i < tLen + 1; i++) {
                middle[0][i] = 0;
            }
            for (int i = 1; i < sLen + 1; i++) {
                for (int j = 1; j < tLen + 1; j++) {
                    if (strS.charAt(i - 1) == strS.charAt(j - 1)) {
                        middle[i][j] = middle[i - 1][j - 1] + 1;
                    } else {
                        middle[i][j] = Math.max(middle[i - 1][j], middle[i][j - 1]);
                    }
                }
            }
            if (middle[sLen][tLen] == tLen) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }
    }
}
