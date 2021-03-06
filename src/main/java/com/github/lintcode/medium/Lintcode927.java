package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 21:00
 * @Description: Given an input character array, reverse the array word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input character array does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * Example
 * Given s = "the sky is blue",
 * after reversing : "blue is sky the"
 * <p>
 * Challenge
 * Could you do it in-place without allocating extra space?
 */
public class Lintcode927 {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if (str == null || str.length == 0) {
            return null;
        }
        //翻转整个数组
        reverse(str, 0, str.length - 1);
        //按单词逐个翻转
        int index = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, index, i - 1);
                //单词和单词之间只用单个空格隔开
                index = i + 1;
            }
        }
        //最后一个单词翻转
        reverse(str, index, str.length - 1);
        return str;
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords__(char[] str) {
        // write your code here
        //先挨个单词翻转
        int n = str.length;
        if (n == 0) {
            return str;
        }
        int fromIndex = 0;
        int endIndex = 0;

        // how are you?
        // woh era ?uoy
        while (endIndex <= n - 1) {
            if (str[endIndex] == ' ') {
                rotate(str, fromIndex, endIndex - 1);
                fromIndex = endIndex + 1;
                endIndex++;
            } else {
                endIndex++;
            }
        }
        //翻转最后一个单词
        rotate(str, fromIndex, n - 1);

        rotate(str, 0, n - 1);

        return str;
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
