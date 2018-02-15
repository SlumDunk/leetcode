package com.github.leetcode.easy;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note: The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer. You could assume no leading zero bit in the integer’s binary
 * representation. 
 * Example 1: Input: 5 Output: 2 Explanation: The binary
 * representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2. 
 * Example 2: Input: 1 Output: 0 Explanation: The
 * binary representation of 1 is 1 (no leading zero bits), and its complement is
 * 0. So you need to output 0.
 * 
 * @author liuzhongda
 *
 */
public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(5));
		System.out.println(findComplementSolution(5));
	}

	public static int findComplement(int num) {
		Boolean start = false;
		for (int i = 31; i >= 0; i--) {
			if ((num & (1 << i)) > 0 && start == false)
				start = true;
			if (start) {
				num ^= (1 << i);
			}
		}
		return num;
	}
	
	public static int findComplementSolution(int num) {
		int mx = Integer.MAX_VALUE;
		while ((mx & num) > 0)
			mx = mx << 1;

		return ~mx & ~num;
	}
}
