package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 5/24/19 21:19
 * @Description: A character is unique in string S if it occurs exactly once in it.
 * <p>
 * For example, in string S = "LETTER", the only unique characters are "L" and "R".
 * <p>
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * <p>
 * For example, UNIQ("LETTER") =  2.
 * <p>
 * Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
 * <p>
 * If there are two or more equal substrings at different positions in S, we consider them different.
 * <p>
 * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 * <p>
 * Input: "ABA"
 * Output: 8
 * Explanation: The same as example 1, except uni("ABA") = 1.
 */
public class Leetcode828 {
    public static void main(String[] args) {
        Leetcode828 leetcode828 = new Leetcode828();
        leetcode828.uniqueLetterString("ABA");
    }

    public int uniqueLetterString(String S) {
        int[] lastAppearPos = new int[26];
        int[] lastLastAppearPos = new int[26];
        //前i个字符能够构成的unique子串长度和
        long[] res = new long[S.length() + 1];
        for (int i = 1; i < res.length; i++) {
            int letter = S.charAt(i - 1) - 'A';
            res[i] = res[i - 1];
            res[i] += (i - lastAppearPos[letter]);
            res[i] -= (lastAppearPos[letter] - lastLastAppearPos[letter]);
            lastLastAppearPos[letter] = lastAppearPos[letter];
            lastAppearPos[letter] = i;
            if (i >> 8 == 0) {
                res[i] %= 1000000007;
            }
        }
        long ans = 0;
        for (int i = 0; i < res.length; i++) {
            ans += res[i];
        }
        return (int) (ans % 1000000007);
    }
}
