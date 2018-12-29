package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 14:50
 * @Description: Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Leetcode402 {
    public static void main(String[] args) {
        Leetcode402 leetcode402 = new Leetcode402();
        System.out.println(leetcode402.removeKdigits("1355457", 3));
    }

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0, len = num.length();
        while (index < len) {
            int temp = Integer.parseInt(num.substring(index, index + 1));
            //把大值出栈，小值代替入栈
            while (!stack.isEmpty() && stack.peek() > temp && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(temp);
            index++;
        }
        //栈非空且还有位数可以删除
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder buffer = new StringBuilder();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                buffer.append(stack.pop());
            }
            String result = buffer.reverse().toString();
            int i = 0;
            //找到第一个非0的位
            while (i < result.length() && result.charAt(i) == '0') {
                i++;
            }
            //如果等于字符串长度，证明结果值是0
            return i == result.length() ? "0" : result.substring(i, result.length());

        } else {
            return "0";
        }
    }
}
