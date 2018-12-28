package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 19:45
 * @Description: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        //每个数字上面可以输出的英文字母
        String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        //从字符串第1个字符开始
        letterCombinations(list, digits, "", 0, table);
        return list;
    }

    /**
     * 回溯递归
     * @param list 结果集
     * @param digits 字符串
     * @param curr 当前字符串
     * @param index 当前位置
     * @param table 数字字母映射表
     */
    private void letterCombinations(List<String> list, String digits, String curr, int index, String[] table) {
        //遍历完字符串
        if (index == digits.length()) {
            if (curr.length() != 0) {
                list.add(curr);
            }
            return;
        }
        //当前数字对应的英文字符串
        String temp = table[digits.charAt(index) - '0'];
        //遍历字符串
        for (int i = 0; i < temp.length(); i++) {
            //每次循环把不同字符串加到当前curr之后
            String next = curr + temp.charAt(i);
            //进入下一层
            letterCombinations(list, digits, next, index + 1, table);
        }
    }
}
