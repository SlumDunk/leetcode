package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 17:14
 * @Description: Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
 * <p>
 * It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
 * <p>
 * Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "?zs"
 * Output: "azs"
 * Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
 * Example 2:
 * <p>
 * Input: s = "ubv?w"
 * Output: "ubvaw"
 * Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
 * Example 3:
 * <p>
 * Input: s = "j?qg??b"
 * Output: "jaqgacb"
 * Example 4:
 * <p>
 * Input: s = "??yw?ipkj?"
 * Output: "acywaipkja"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only lower case English letters and '?'.
 */
public class Leetcode1576 {
    public String modifyString(String s) {
        if (s == null || s.isEmpty())
            return s;

        StringBuilder sb = new StringBuilder(s);
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '?') {
                char l = i > 0 ? sb.charAt(i - 1) : '-';
                char r = i + 1 < N ? sb.charAt(i + 1) : '-';
                //finding good char to use for replacement, it must be not equal to one to the
                //right or one to the left
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != l && ch != r) {
                        sb.setCharAt(i, ch);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
