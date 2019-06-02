package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 18:37
 * @Description: A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * <p>
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * <p>
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */
public class Leetcode1021 {
    public String removeOuterParentheses(String S) {
        if (S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            count = c == '(' ? count + 1 : count - 1;
            if (count == 0) {
                count = 1;
                i++;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
