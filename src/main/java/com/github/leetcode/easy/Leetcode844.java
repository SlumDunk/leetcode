package com.github.leetcode.easy;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */
public class Leetcode844 {
    public boolean backspaceCompare(String S, String T) {
        //这里用Buffer来模拟stack的作用
        StringBuffer SBuffer = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            if ('#' == S.charAt(i)) {
                if (SBuffer.length() > 0) {//模拟栈非空出栈
                    SBuffer.deleteCharAt(SBuffer.length() - 1);
                }
            } else {
                SBuffer.append(S.charAt(i));
            }
        }
        StringBuffer TBuffer = new StringBuffer();
        for (int i = 0; i < T.length(); i++) {
            if ('#' == T.charAt(i)) {
                if (TBuffer.length() > 0) {//模拟栈非空出栈
                    TBuffer.deleteCharAt(TBuffer.length() - 1);
                }
            } else {
                TBuffer.append(T.charAt(i));
            }
        }
        return SBuffer.toString().equals(TBuffer.toString());
    }
}
