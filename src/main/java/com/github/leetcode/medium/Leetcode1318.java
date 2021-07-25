package com.github.leetcode.medium;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 * Example 2:
 * <p>
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 * Example 3:
 * <p>
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class Leetcode1318 {
    public int minFlips(int a, int b, int c) {
        String aB = Integer.toBinaryString(a);
        String bB = Integer.toBinaryString(b);
        String cB = Integer.toBinaryString(c);

        int aIndex = aB.length() - 1;
        int bIndex = bB.length() - 1;
        int cIndex = cB.length() - 1;

        int ans = 0;

        while (aIndex >= 0 || bIndex >= 0 || cIndex >= 0) {
            char first = (aIndex >= 0) ? aB.charAt(aIndex) : '0';
            char second = (bIndex >= 0) ? bB.charAt(bIndex) : '0';
            char third = (cIndex >= 0) ? cB.charAt(cIndex) : '0';

            if (third == '0') {
                ans += (first == '1') ? 1 : 0;
                ans += (second == '1') ? 1 : 0;
            } else {
                if (first == '0' && second == '0') {
                    ans++;
                }
            }

            aIndex--;
            bIndex--;
            cIndex--;
        }

        return ans;
    }
}
