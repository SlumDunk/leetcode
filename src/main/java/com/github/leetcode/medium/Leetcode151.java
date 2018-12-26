package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:25
 * @Description: Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class Leetcode151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //对于只有空格的情况，则去除所有空格，返回即可
        if (s.trim().length() == 0)
            return s.trim();

        //去除一句话两端多余的空格
        s = s.trim();
        String[] array = s.split(" ");
        StringBuilder buffer = new StringBuilder("");
        //从后往前走，走到第二个，第一个做特殊处理
        for (int i = array.length - 1; i >= 1; i--) {
            //由于句子中也可能会有很多空格，所以会产生多余的“”
            if (array[i].equals(""))
                continue;
            buffer.append(array[i]);
            buffer.append(" ");
        }
        buffer.append(array[0]);
        return buffer.toString();
    }

}
