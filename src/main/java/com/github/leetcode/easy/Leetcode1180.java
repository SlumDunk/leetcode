package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 21:38
 * @Description: Given a string S, return the number of substrings that have only one distinct letter.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aaaba"
 * Output: 8
 * Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
 * "aaa" occurs 1 time.
 * "aa" occurs 2 times.
 * "a" occurs 4 times.
 * "b" occurs 1 time.
 * So the answer is 1 + 2 + 4 + 1 = 8.
 * Example 2:
 * <p>
 * Input: S = "aaaaaaaaaa"
 * Output: 55
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= S.length <= 1000
 * S[i] consists of only lowercase English letters.
 */
public class Leetcode1180 {
    public static void main(String[] args) {
        Leetcode1180 leetcode1180 = new Leetcode1180();
        leetcode1180.countLetters("aaaba");
    }

    /**
     * 滑动窗口
     *
     * @param S
     * @return
     */
    public int countLetters(String S) {
        if (S == null) return 0;
        int count = 0;
        int total = 0;
        char[] charr = S.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            if (i == 0 || charr[i - 1] != charr[i]) {
                count = 1;
            } else {
                count++;
            }
            total += count;
        }
        return total;

    }

    private boolean unique(int i, int j, char[] array) {
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
