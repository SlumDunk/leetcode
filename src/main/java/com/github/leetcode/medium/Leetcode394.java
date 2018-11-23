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
    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();//用Stack处理包含关系
        result.push("");
        int i = 0;

        while(i<s.length()){
            char a = s.charAt(i);
            if(a >= '0' && a <= '9'){
                int startIndex = i;
                while(Character.isDigit(s.charAt(i+1))) i++;
                count.push(Integer.parseInt(s.substring(startIndex,i+1)));
            } else if (a == '[') {
                result.push("");//用初始化空字符串处理并列关系
            } else if(a == ']') {
                String temp = new String(result.pop());
                StringBuilder sb = new StringBuilder();
                int nloop = count.pop();
                for(int j = 0; j < nloop;j++)
                    sb.append(temp);
                result.push(result.pop()+sb.toString());
            } else {
                result.push(result.pop()+a);
            }
            i++;
        }
        return result.pop();
    }
}
