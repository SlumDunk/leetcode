package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 11/20/18 10:49
 * @Description: Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Leetcode394 {
    public static void main(String[] args) {
        Leetcode394 leetcode394 = new Leetcode394();
        System.out.println(leetcode394.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        int i = 0, len = s.length();
        //应付输入字符串为空串和没[]的情况
        strStack.push("");

        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {//当前字符是数字
                int startIndex = i;
                while (Character.isDigit(s.charAt(++i))) ;
                countStack.push(Integer.parseInt(s.substring(startIndex, i)));
                i--;
            } else if ('[' == s.charAt(i)) {//开启新的嵌套
                strStack.push("");
            } else if (']' == s.charAt(i)) {
                int counts = countStack.pop();
                String top = strStack.pop();
                StringBuilder buffer = new StringBuilder();
                for (int j = 0; j < counts; j++) {
                    buffer.append(top);
                }
                if (strStack.isEmpty()) {//栈为空，直接进栈,证明已经走完了
                    strStack.push(buffer.toString());
                } else {
                    strStack.push(strStack.pop() + buffer.toString());
                }
            } else {
                strStack.push(strStack.pop() + s.charAt(i));
            }
            i++;
        }
        return strStack.pop();
    }
}
