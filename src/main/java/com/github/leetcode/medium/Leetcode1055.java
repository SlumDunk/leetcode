package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 08:04
 * @Description: From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 * <p>
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 * <p>
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
 * Example 3:
 * <p>
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 * <p>
 * <p>
 * Note:
 * <p>
 * Both the source and target strings consist of only lowercase English letters from "a"-"z".
 * The lengths of source and target string are between 1 and 1000.
 */
public class Leetcode1055 {
    /**
     * 保存target下次要比较的开始位置
     */
    int pos;

    public int shortestWay(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        pos = 0;
        int cnt = 0;
        while (pos < t.length) {
            int pre = pos;
            forward(s, t);
            if (pos == pre) {//出现不明字符，无法前进
                return -1;
            }
            ++cnt;
        }
        return cnt;
    }

    /**
     * @param s
     * @param t
     */
    private void forward(char[] s, char[] t) {
        for (int i = 0; pos < t.length && i < s.length; ++i) {
            if (s[i] == t[pos]) {
                ++pos;
            }
        }
    }
}
