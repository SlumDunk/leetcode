package com.github.leetcode.easy;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 16:43
 * @Description: Given a sequence of words, check whether it forms a valid word square.
 * <p>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crmy".
 * The fourth row and fourth column both read "dtye".
 * <p>
 * Therefore, it is a valid word square.
 * Example 2:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crm",
 * "dt"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crm".
 * The fourth row and fourth column both read "dt".
 * <p>
 * Therefore, it is a valid word square.
 * Example 3:
 * <p>
 * Input:
 * [
 * "ball",
 * "area",
 * "read",
 * "lady"
 * ]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The third row reads "read" while the third column reads "lead".
 * <p>
 * Therefore, it is NOT a valid word square.
 */
public class Leetcode422 {
    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        for (int i = 0; i < size; i ++) {
            String wi = words.get(i);
            int len = wi.length();

            // starting from i
            // compare s(i, j) and s(j, i)
            for (int j = i; j < len; j ++) {
                if (j >= size || i >= words.get(j).length() || wi.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }

            // for those j >=len, make sure s(j, i) does not exst
            for (int j = len; j < size; j ++) {
                if (i < words.get(j).length()) {
                    return false;
                }
            }
        }

        return true;
    }
}
