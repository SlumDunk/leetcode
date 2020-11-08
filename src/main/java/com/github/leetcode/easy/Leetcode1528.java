package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 19:57
 * @Description: Given a string s and an integer array indices of the same length.
 * <p>
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * <p>
 * Return the shuffled string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 * Example 2:
 * <p>
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: After shuffling, each character remains in its position.
 * Example 3:
 * <p>
 * Input: s = "aiohn", indices = [3,1,4,2,0]
 * Output: "nihao"
 * Example 4:
 * <p>
 * Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * Output: "arigatou"
 * Example 5:
 * <p>
 * Input: s = "art", indices = [1,0,2]
 * Output: "rat"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s contains only lower-case English letters.
 * 0 <= indices[i] < n
 * All values of indices are unique (i.e. indices is a permutation of the integers from 0 to n - 1).
 */
public class Leetcode1528 {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[indices[i]] = s.charAt(i);
        }
        return new String(array);
    }
}
