package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 17:21
 * @Description: We have a string S of lowercase letters, and an integer array shifts.
 * <p>
 * Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 * <p>
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * <p>
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 * <p>
 * Return the final string after all such shifts to S are applied.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation:
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 * Note:
 * <p>
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 */
public class Leetcode848 {
    public String shiftingLetters(String S, int[] shifts) {
        int c = 0;
        char[] charArray = S.toCharArray();
        //从后往前推
        for (int i = shifts.length - 1; i >= 0; --i) {
            c += (shifts[i] % 26);
            charArray[i] = (char) ((charArray[i] - 'a' + c) % 26 + 'a');
        }
        return new String(charArray);
    }
}
