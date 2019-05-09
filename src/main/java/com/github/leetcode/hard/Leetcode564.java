package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 08:38
 * @Description: Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * <p>
 * The 'closest' is defined as absolute difference minimized between two integers.
 * <p>
 * Example 1:
 * Input: "123"
 * Output: "121"
 * Note:
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer.
 */
public class Leetcode564 {
    /**
     * For a palindrome number, e.g., 12321, the next bigger palindrome should be 12421, and the next smaller one should be 12221. That is, if we define 123 as palindromeRoot of 12321, the next bigger palindrome number's palindromeRoot ispalindromeRoot + 1, while the next smaller one's palindromeRoot ispalindromeRoot - 1. For palindrome numbers with even digits, e.g., 123321, the change of palindromeRoot follows the same pattern. And the closest palindromic one should be among the palindromic numbers formed by these two palindromeRoots.
     * <p>
     * Inspired by the idea above, for a number which is not palindromic, e.g., 12345, we still focus on the front half of the number, i.e., palindromeRoot as 123 in the example. Except for the bigger one formed by palindromeRoot + 1(124), the smaller one formed by palindromeRoot - 1(122), there should be one more possibility, i.e., the number formed by palindromeRoot (123). We chose the closest one among these three palindromic numbers formed.
     * <p>
     * There are some cases missing the rules above,
     * case 1. smaller than or equal to 10 OR 100, 1000, 10000, ... We simply decrease n by 1.
     * case 2. 11, 101, 1001, 10001, 100001, ... We simply decrease n by 2.
     * case 3. 99, 999, 9999, 99999, ... We simply increase n by 2.
     *
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        long nVal = Long.parseLong(n);
        if (nVal <= 10 || ((nVal % 10 == 0) && (n.charAt(0) == '1') && (Integer.valueOf(n.substring(1))) == 0)) {
            return String.valueOf(nVal - 1);
        }

        if (nVal == 11 || (nVal % 10 == 1) && (n.charAt(0) == '1') && (n.charAt(n.length() - 1) == '1') && (Integer.valueOf(n.substring(1, n.length() - 1)) == 0)) {
            return String.valueOf(nVal - 2);
        }

        boolean notAllNine = false;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '9') {
                notAllNine = true;
            }
        }

        if (!notAllNine && nVal >= 99) {
            return String.valueOf(nVal + 2);
        }

        String palindromeRoot = n.substring(0, (n.length() + 1) / 2);
        int valPalindromeRoot = Integer.valueOf(palindromeRoot);
        boolean isEven = n.length() % 2 == 0;
        long tmpEqual = Long.parseLong(toPalindromeDigits(valPalindromeRoot, isEven));
        long tmpBigger = Long.parseLong(toPalindromeDigits(valPalindromeRoot + 1, isEven));
        long tmpSmaller = Long.parseLong(toPalindromeDigits(valPalindromeRoot - 1, isEven));

        long distEqual = Math.abs(nVal - tmpEqual);
        long distBigger = Math.abs(nVal - tmpBigger);
        long distSmaller = Math.abs(nVal - tmpSmaller);

        long distMin = 0;
        if (distEqual == 0) {
            distMin = Math.min(distBigger, distSmaller);
        } else {
            distMin = Math.min(Math.min(distEqual, distSmaller), distBigger);
        }
        if (distMin == distSmaller) {
            return String.valueOf(tmpSmaller);
        }
        if (distMin == distEqual) {
            return String.valueOf(tmpEqual);
        }
        return String.valueOf(tmpBigger);
    }

    private String toPalindromeDigits(int num, boolean isEven) {
        String numStr = String.valueOf(num);
        if (isEven) {
            return numStr + (new StringBuilder(numStr).reverse()).toString();
        }

        return numStr + (new StringBuilder(numStr).reverse().deleteCharAt(0)).toString();
    }
}
