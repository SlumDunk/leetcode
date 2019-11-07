package com.github.leetcode.easy;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * @author liuzhongda
 */
public class Leetcode557 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(reverseWords(""));
    }

    public static String reverseWords(String s) {
        //先对字符串按空格做切分
        String[] array = s.split(" ");
        StringBuilder buffer = new StringBuilder();
        for (String value : array) {
            for (int i = value.length() - 1; i >= 0; i--) {
                buffer.append(value.charAt(i));
            }

            buffer.append(" ");
        }
        return buffer.substring(0, buffer.length() - 1);
    }

    /**
     * reverse each word
     *
     * @param word the input word
     * @return
     */
    private static String reverseWord(String word) {
        // TODO Auto-generated method stub
        char[] arrayChar = word.toCharArray();
        char[] newarrayChar = new char[word.length()];
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i <= arrayChar.length - 1; i++) {
            stack.push(arrayChar[i]);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            newarrayChar[count] = stack.pop();
            count++;
        }
        return new String(newarrayChar);
    }


    public String reverseWords_(String s) {
        //先对字符串按空格做切分
        char[] array = s.toCharArray();

        int nxt = 0;
        while (nxt < array.length) {
            int l = nxt;

            while (nxt < array.length && array[nxt] != ' ') {
                nxt++;
            }

            reverse(array, l, nxt - 1);
            //skip space
            nxt++;
        }

        return new String(array);
    }

    public void reverse(char[] array, int l, int r) {
        while (l < r) {
            char temp = array[r];
            array[r] = array[l];
            array[l] = temp;
            l++;
            r--;
        }
    }
}
