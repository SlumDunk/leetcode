package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 15:47
 * @Description: Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.
 * <p>
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
 * <p>
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 * <p>
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 * <p>
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= N < 10^9
 */
public class Leetcode1009 {
    public static void main(String[] args) {
        Leetcode1009 leetcode1009 = new Leetcode1009();
        leetcode1009.bitwiseComplement(5);
    }

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        System.out.println(Integer.toBinaryString(N));
        int numberOfBinaryBits = 32 - Integer.numberOfLeadingZeros(N);
        System.out.println(Integer.toBinaryString(-1 << numberOfBinaryBits));
        int mask = ~(-1 << numberOfBinaryBits);
        System.out.println(Integer.toBinaryString(mask));
        return ~N & mask;
    }
}
