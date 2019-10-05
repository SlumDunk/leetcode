package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 11:37
 * @Description: Given a string s that consists of lower case English letters and brackets.
 * <p>
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * <p>
 * Your result should not contain any bracket.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * <p>
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Example 3:
 * <p>
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Example 4:
 * <p>
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It's guaranteed that all parentheses are balanced.
 */
public class Leetcode1190 {
    public static void main(String[] args) {
        Leetcode1190 leetcode1190 = new Leetcode1190();
        leetcode1190.reverseParentheses("(abcd)");
    }

    class Pair {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public String reverseParentheses(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        Stack<Pair> stack = new Stack<Pair>();
        int left, right;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                count++;
                left = i + 1;
                stack.push(new Pair(left, count));
            } else if (array[i] == ')') {
                right = i - 1;
                Pair pair = stack.pop();
                reverseString(array, pair.index, right);
            } else {
                continue;
            }
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] != '(' && array[i] != ')') {
                buffer.append(array[i]);
            }
        }
        return buffer.toString();
    }

    public void reverseString(char[] array, int left, int right) {
        char temp;
        while (left < right) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
