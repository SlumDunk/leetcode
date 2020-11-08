package com.github.leetcode.medium;

import java.util.LinkedList;
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

    /**
     * O(n)
     *
     * @param s
     * @return
     */
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


    /**
     * O(n)
     *
     * @param s
     * @return
     */
    public String decodeString_(String s) {
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        int i = 0, len = s.length();

        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {//当前字符是数字
                int val = c - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    val = val * 10 + (s.charAt(i) - '0');
                }
                countStack.push(val);
            } else if ('[' == c) {//开启新的嵌套
                strStack.push("" + c);
            } else if (']' == c) {
                LinkedList<String> tmp = new LinkedList<>();
                while (!strStack.isEmpty() && !strStack.peek().equals("[")) {
                    tmp.addFirst(strStack.pop());
                }
                if (!strStack.isEmpty()) {
                    strStack.pop();
                }
                StringBuilder substr = new StringBuilder();
                for (String item : tmp) {
                    substr.append(item);
                }
                int counts = countStack.pop();
                StringBuilder buffer = new StringBuilder();
                for (int j = 0; j < counts; j++) {
                    buffer.append(substr);
                }

                strStack.push(buffer.toString());
            } else {
                strStack.push("" + c);
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        LinkedList<String> tmp = new LinkedList<>();
        while (!strStack.isEmpty()) {
            tmp.addFirst(strStack.pop());
        }

        for (String item : tmp) {
            ans.append(item);
        }
        return ans.toString();
    }
}
