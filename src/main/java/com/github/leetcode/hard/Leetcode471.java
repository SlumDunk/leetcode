package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 22:14
 * @Description: Given a non-empty string, encode the string such that its encoded length is the shortest.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * <p>
 * Note:
 * <p>
 * k will be a positive integer and encoded string will not be empty or have extra space.
 * You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
 * If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "aaa"
 * Output: "aaa"
 * Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "aaaaa"
 * Output: "5[a]"
 * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: "aaaaaaaaaa"
 * Output: "10[a]"
 * Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
 * <p>
 * <p>
 * Example 4:
 * <p>
 * Input: "aabcaabcd"
 * Output: "2[aabc]d"
 * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 * <p>
 * <p>
 * Example 5:
 * <p>
 * Input: "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
 */
public class Leetcode471 {
    public static void main(String[] args) {
        Leetcode471 leetcode471 = new Leetcode471();
        String s = "aabcaabcd";
        leetcode471.encode(s);
    }

    public String encode(String s) {
        if (s.length() <= 4)
            return s;
        int n = s.length();
        //开始位置，长度
        String[][] dp = new String[n][n];
        //子串长度
        for (int l = 1; l <= n; l++) {
            //开始位置
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (l <= 4) {
                    dp[i][j] = s.substring(i, j + 1);
                } else {
                    dp[i][j] = getShortestEncode(s.substring(i, j + 1), i, dp);
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length())
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * @param s     字符串
     * @param start 开始位置
     * @param dp    dp数组
     * @return
     */
    private String getShortestEncode(String s, int start, String[][] dp) {
        int n = s.length();
        String ret = s;
        int index = getKMPTailIndex(s);
        String sub = s.substring(index + 1);
        int m = sub.length();
        if (n % m == 0) {
            for (int i = 0; i < n; i += m) {
                if (!s.substring(i, i + m).equals(sub))
                    return ret;
            }
            String tmp = n / m + "[" + dp[start][start + m - 1] + "]";
            if (tmp.length() < ret.length())
                return tmp;
        }
        return ret;
    }

    /**
     * KMP算法
     *
     * @param s
     * @return
     */
    private int getKMPTailIndex(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] kmp = new int[n];
        int i = 2;
        int j = 0;
        while (i < n) {
            if (cs[i - 1] == cs[j]) {
                j++;
                kmp[i++] = j;
            } else if (j > 0) {
                j = kmp[j];
            } else {
                i++;
            }
        }
        return kmp[n - 1];
    }
}
