package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 10:46
 * @Description: Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Leetcode179 {
    public static void main(String[] args) {
        Leetcode179 leetcode179 = new Leetcode179();
        System.out.println(leetcode179.largestNumber(new int[]{3, 30, 5, 34, 9, 10}));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s_num = new String[nums.length];
        //转换为字符串数组
        for (int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);
        //首位从大到小排列
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String str1, String str2) {
                return (str2 + str1).compareTo(str1 + str2);
            }
        };
        Arrays.sort(s_num, comp);
        if (s_num[0].charAt(0) == '0') return "0";
        //拼接成结果
        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);
        return sb.toString();
    }
}
