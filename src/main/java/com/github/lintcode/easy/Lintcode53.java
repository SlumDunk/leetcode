package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 20:46
 * @Description: Given an input string, reverse the string word by word.
 * <p>
 * Example
 * Given s = "the sky is blue",
 * <p>
 * return "blue is sky the".
 * <p>
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class Lintcode53 {
    /*
    * @param s: A string
    * @return: A string
    */
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder buffer = new StringBuilder("");
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                if (buffer.length() > 0) {
                    buffer.append(" ");
                }
            }
            buffer.append(array[i]);
        }
        return buffer.toString();
    }

    /*
        * @param s: A string
        * @return: A string
        */
    public String reverseWords__(String s) {
        // write your code here
        //先挨个单词翻转
        int n = s.length();
        char[] array = s.toCharArray();
        int fromIndex = 0;
        int endIndex = -1;

        // how are you?
        // woh era ?uoy
        while ((endIndex = s.indexOf(" ", fromIndex)) != -1) {
            rotate(array, fromIndex, endIndex - 1);
            fromIndex = endIndex + 1;
        }
        //翻转最后一个单词
        rotate(array, fromIndex, n - 1);

        rotate(array, 0, n - 1);
        StringBuilder buffer = new StringBuilder("");
        for (char item : array) {
            if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == ' ' && item == ' ') {
                continue;
            } else {
                if (buffer.length() == 0 && item == ' ') {
                    continue;
                }
                buffer.append(item);
            }
        }

        return buffer.toString();
    }

    private void rotate(char[] array, int start, int end) {
        char temp;

        while (start < end) {
            temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }
}
