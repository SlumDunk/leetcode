package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771 Jewels and Stones
 * <p>
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 * <p>
 * Input: J = "z", S = "ZZ" Output: 0 Note:
 * <p>
 * S and J will consist of letters and have length at most 50. The characters in
 * J are distinct.
 *
 * @author liuzhongda
 */
public class Leetcode771 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

    }

    public static int numJewelsInStones(String J, String S) {
        //先遍历J的字符，将他们放进Set里头
        Set<Character> charSet = new HashSet<Character>();
        for (char value : J.toCharArray()) {
            charSet.add(value);
        }
        //遍历S的字符，统计属于宝石的个数
        int count = 0;
        for (char value : S.toCharArray()) {
            if (charSet.contains(value)) {
                count++;
            }
        }
        return count;
    }

}
