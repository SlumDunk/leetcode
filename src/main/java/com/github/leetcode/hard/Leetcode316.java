package com.github.leetcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 15:13
 * @Description: Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class Leetcode316 {
    Stack<Integer> stack = new Stack<>();
    boolean vis[] = new boolean[26];
    int[] num = new int[26];

    /**
     * 用一个栈来维护答案，从左往右扫描字符串，当栈顶元素字典序大于当前扫描的字符，
     * 并且栈顶元素在s未被扫描到的部分中还有出现时，栈顶元素出栈，并继续比较新的
     * 栈顶元素与当前字符字符，重复上面的过程，直到不符合上述条件时，再让当前字符
     * 入栈。最后答案就是栈底到栈顶元素组成的字符串。
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int id = s.charAt(i) - 'a';
            num[id]--;
            if (vis[id]) continue;
            while (!stack.isEmpty() && stack.peek() > id && num[stack.peek()] > 0) {
                vis[stack.peek()] = false;
                stack.pop();
            }
            stack.push(id);
            vis[id] = true;
        }
        String ans = "";
        for (Integer element :
                stack) {
            ans += (char) ('a' + element);
        }
        return ans;
    }
}
