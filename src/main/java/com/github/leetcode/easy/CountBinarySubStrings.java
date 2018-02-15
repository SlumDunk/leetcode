package com.github.leetcode.easy;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's 
 * and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.
 * @author liuzhongda
 *
 */
public class CountBinarySubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countBinarySubstrings(String s) {
		int len = s.length();
		if (len <= 1)
			return 0;
		char[] arrChar = s.toCharArray();
		int prevRunLen = 0, curRunLen = 1, res = 0;
		for (int i = 1; i < len-1; i++) {
			if (arrChar[i] == arrChar[i + 1])
				curRunLen++;
			else {
				prevRunLen = curRunLen;
				curRunLen = 1;
			}
			if (prevRunLen >= curRunLen)
				res++;
		}
		return res;
	}

	public int anotherCountBinarySubstrings(String s) {
		int len = s.length();
		if (len <= 1)
			return 0;
		char[] sc = s.toCharArray();
		int[] count = new int[len];
		int tmp = 0;
		for (int i = 0; i < len - 1; i++) {
			count[tmp]++;
			if (sc[i] != sc[i + 1])
				tmp++;
		}
		if (sc[len - 1] == sc[len - 2])
			count[tmp]++;
		else
			count[tmp]++;

		int res = 0;
		for (int i = 0; i < tmp; i++) {
			res += Math.min(count[i], count[i + 1]);
		}
		return res;
	}

	public int anotherSecondCountBinarySubstrings(String s) {
		int len = s.length();
		if (len <= 1)
			return 0;
		char[] sc = s.toCharArray();
		int i = 0, prev = -1, res = 0;
		while (i < len) {
			int j = i;
			char c = sc[i];
			// 统计相同元素的个数
			while (i < len && sc[i] == c)
				i++;
			int cur = i - j;
			// 对相邻连续子串的较小值进行求和。这里使用两个变量来代替之前的一个数组，而且再一次遍历中执行计数和求和两部分功能
			if (prev != -1)
				res += Math.min(prev, cur);
			prev = cur;
		}
		return res;
	}
}
