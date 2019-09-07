package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 14:18
 * @Description: A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * <p>
 * <p>
 * Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
 * <p>
 * Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
 * <p>
 * Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: seq = "(()())"
 * Output: [0,1,1,1,1,0]
 * Example 2:
 * <p>
 * Input: seq = "()(())()"
 * Output: [0,0,0,1,1,0,1,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= seq.size <= 10000
 */
public class Leetcode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] ans = new int[len];
        int[] record = new int[len];
        if (len < 3) return ans;
        Stack<Character> stack = new Stack<>();
        int total_dep = 0;
        int c = 0;
        char[] cs = seq.toCharArray();
        for (int i = 0; i < len; i++) {

            if (cs[i] == '(') {
                c++;
                record[i] = c;
            } else if (cs[i] == ')') {
                record[i] = c;
                c--;
            }

            //update max depth
            if (c > total_dep) total_dep = c;
        }
        if (total_dep < 2) return ans;
        int half = total_dep / 2;
        for (int i = 0; i < len; i++) {
            if (record[i] <= half) ans[i] = 0;
            else ans[i] = 1;
        }
        return ans;
    }
}
