package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 16:13
 * @Description: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Leetcode13 {
    public int romanToInt(String s) {
//注意组合的优先级
        //复合字符子串，前一个字符小于第二个字符
        //M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,I
        //1000,900,500,400,100,90,50,40,10,9,5,4,1
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] val = {1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < symbol.length; i++) {
            map.put(symbol[i], val[i]);
        }

        int len = s.length();
        int res = 0;

        res += map.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int cur = map.get(s.charAt(i));
            int prev = map.get(s.charAt(i - 1));
            if (cur > prev) {//复合
                res += cur - 2 * prev;
            } else {//单个
                res += cur;
            }
        }
        return res;
    }
}
