package com.github.leetcode.easy;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note: 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are
 * different. Ï *
 *
 * @author liuzhongda
 */
public class Leetcode461 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static int hammingDistance(int x, int y) {
//		int res = 0, exc = x ^ y;
//		while (exc != 0) {
//			res++;
//			exc &= (exc - 1);
//		}
//		return res;
        //统计异或结果中1的个数即可
        int res = 0, exc = x ^ y;
        int j = 1 << 30;
        for (int i = 0; i < 31; i++) {
            int bit = (j & exc) == 0 ? 0 : 1;
            res += bit;
            j >>= 1;
        }
        return res;
    }

}
