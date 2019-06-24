package com.github.leetcode.hard;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/5/19 10:15
 * @Description: Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.
 * <p>
 * Example 1:
 * Input: 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 * Note: 1 <= n <= 109
 */
public class Leetcode600 {
    public static void main(String[] args) {
        Leetcode600 leetcode600 = new Leetcode600();
        System.out.println(leetcode600.findIntegers(
                9));
    }

    public int findIntegers(int num) {
        //高位到低位
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        //以0结尾 没有连续的1
        int a[] = new int[n];
        //以1结尾 没有连续的1
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            //以0结尾00, 10
            a[i] = a[i - 1] + b[i - 1];
            //以1结尾，01
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        //1001 1001
        for (int i = n - 2; i >= 0; i--) {
            //连续两个1
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            //连续两个0 01不能出现
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }
        //4 001
        // 0, 1  a[0]=b[0]=1
        //00 10, 01 a[1]=2, b[1]=1
        //000 100 010, 001 101 a[2]=3 b[2]=2

        //0000 1000 0100 0010 1010, 0001 1001 0101 a[3]=5 b[3]=3

        return result;

    }
}
