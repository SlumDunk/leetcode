package com.github.leetcode.easy;

/**
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence
 * should not be any subsequence of the other strings.
 * <p>
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order
 * of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * <p>
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon
 * subsequence doesn't exist, return -1.
 * <p>
 * Example 1:
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
 * because "aba" is a subsequence of "aba",
 * but not a subsequence of any other strings in the group of two strings.
 * Note:
 * <p>
 * Both strings' lengths will not exceed 100.
 * Only letters from a ~ z will appear in input strings.
 *
 * @author liuzhongda
 */
public class Leetcode521 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = new String("abc");
        String b = new String("abc");
        String c = "abc";
        String d = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(a == c);
        System.out.println(a.equals(c));
    }

    public int findLUSlength(String a, String b) {
        //字符串相等，返回-1
        if (a.equals(b)) {
            return -1;
        } else {
            //返回长度较长的字符串长度
            return Math.max(a.length(), b.length());
        }
    }

}
