package com.github.leetcode.easy;

/**
 * 771 Jewels and Stones
 * 
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * Example 1:
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 * 
 * Input: J = "z", S = "ZZ" Output: 0 Note:
 * 
 * S and J will consist of letters and have length at most 50. The characters in
 * J are distinct.
 * 
 * @author liuzhongda
 *
 */
public class Leetcode771 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));

	}

	public static int numJewelsInStones(String J, String S) {
		if(J.length()>50 || S.length()>50) {
			System.out.println("the length of the input parameters is more than 50!");
			return 0;
		}
		int[] count=new int[64];
		
		for(char c:J.toCharArray()) {
			count[c-'A']++;
		}
		int ans=0;
		for(char c:S.toCharArray()) {
			if(count[c-'A']>=1) ans++;
		}
		
		return ans;
	}

}
