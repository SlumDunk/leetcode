package com.github.leetcode.medium;

/**
 * A happy string is a string that:
 * <p>
 * consists only of letters of the set ['a', 'b', 'c'].
 * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
 * <p>
 * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
 * <p>
 * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 * Example 2:
 * <p>
 * Input: n = 1, k = 4
 * Output: ""
 * Explanation: There are only 3 happy strings of length 1.
 * Example 3:
 * <p>
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 * Example 4:
 * <p>
 * Input: n = 2, k = 7
 * Output: ""
 * Example 5:
 * <p>
 * Input: n = 10, k = 100
 * Output: "abacbabacb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10
 * 1 <= k <= 100
 */
public class Leetcode1415 {
    String res = "";
    int k;

    char[] characters = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        int total = 3 * (int) Math.pow(2, n - 1);
        if (k > total) {
            return "";
        }

        StringBuilder temp = new StringBuilder();
        this.k = k;
        helper(temp, n);
        return res;
    }

    private void helper(StringBuilder temp, int n) {
        if (k < 0) {
            return;
        }
        if (n == 0) {
            if (--k == 0) {
                res = temp.toString();
            }
            return;
        }

        for (char character :
                characters) {
            if (temp.length() > 0 && temp.charAt(temp.length() - 1) == character) {
                continue;
            }
            temp.append(character);
            helper(temp, n - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
