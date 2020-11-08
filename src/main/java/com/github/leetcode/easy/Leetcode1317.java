package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/2/20 20:20
 * @Description: Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
 * <p>
 * Return a list of two integers [A, B] where:
 * <p>
 * A and B are No-Zero integers.
 * A + B = n
 * It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [1,1]
 * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
 * Example 2:
 * <p>
 * Input: n = 11
 * Output: [2,9]
 * Example 3:
 * <p>
 * Input: n = 10000
 * Output: [1,9999]
 * Example 4:
 * <p>
 * Input: n = 69
 * Output: [1,68]
 * Example 5:
 * <p>
 * Input: n = 1010
 * Output: [11,999]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 10^4
 */
public class Leetcode1317 {
    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        int j = n - 1;
        while (!check(i, j)) {
            i++;
            j--;
        }
        return new int[]{i, j};
    }

    private boolean check(int x, int y) {
        String a = Integer.toString(x);
        String b = Integer.toString(y);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') return false;
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '0') return false;
        }
        return true;
    }
}
