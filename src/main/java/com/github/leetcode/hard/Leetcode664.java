package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 19:18
 * @Description: There is a strange printer with the following two special requirements:
 * <p>
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.
 * <p>
 * Example 1:
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * Hint: Length of the given string will not exceed 100.
 */
public class Leetcode664 {
    private int[][] memo;

    public int strangePrinter(String s) {
        int l = s.length();
        memo = new int[l][l];
        return turn(s.toCharArray(), 0, l - 1);
    }

    /**
     * 从s[i] 打印到 s[j]
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int turn(char[] s, int i, int j) {
        // Empty string
        if (i > j) return 0;
        // Solved
        if (memo[i][j] > 0) return memo[i][j];
        // Default behavior, print s[i] to s[j-1] and print s[j]
        int ans = turn(s, i, j - 1) + 1;
        for (int k = i; k < j; ++k)
            if (s[k] == s[j])
                ans = Math.min(ans, turn(s, i, k) + turn(s, k + 1, j - 1));

        return memo[i][j] = ans;
    }

}
