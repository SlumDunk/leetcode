package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 20:57
 * @Description: Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * For example, Given word = “eceba” and k = 2,
 * <p>
 * T is "ece" which its length is 3.
 * <p>
 * <p>
 * 拥有K个distinct字符的子串的最大长度
 */
public class Leetcode340 {
    public static void main(String[] args) {
        Leetcode340 leetcode340 = new Leetcode340();
        String s = "ecebeea";
        System.out.println(leetcode340.lengthOfLongestSubstringKDistinct(s, 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() <= k) {
            return s == null ? 0 : s.length();
        }
        int len = s.length();
        //开始指针
        int left = 0;
        //最大长度
        int max = 0;
        //存储每个字符最近一次出现的次数 left右边
        Map<Character, Integer> charMap = new HashMap<>();
        //子串中字符的类别数量
        int count = 0;
        //滑动的指针
        int index = left;
        while (index < len) {
            //第一次出现
            if (!charMap.containsKey(s.charAt(index))) {
                count++;
                charMap.put(s.charAt(index), 1);
                //判断是否超出范围了,需要移动指针
                while (count > k) {
                    //如果这子串中left字符只出现一次，那么删除它可以满足，left继续前进
                    if (charMap.get(s.charAt(left)) == 1) {
                        count--;
                        charMap.remove(s.charAt(left));
                    } else {
                        charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
            } else {
                charMap.put(s.charAt(index), charMap.get(s.charAt(index)) + 1);
            }
            max = Math.max(max, index - left + 1);
            index++;
        }
        return max;
    }
}
