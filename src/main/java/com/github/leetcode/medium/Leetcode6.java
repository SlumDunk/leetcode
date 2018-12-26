package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 11:17
 * @Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Leetcode6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0)
            return "";
        if (numRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        //去头去尾,每size个字符构成一个周期
        int size = 2 * numRows - 2;
        //从第一列每个元素开始处理
        for (int i = 0; i < numRows; i++) {
            //每个周期的开始位置
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                //首尾行不处理
                if (i != 0 && i != numRows - 1) {
                    //从下一周期开始位置反推中间夹着的同行异列的字符位置
                    //去头去尾
                    int temp = j + size - 2 * i;
                    if (temp < s.length()) {
                        res.append(s.charAt(temp));
                    }
                }
            }
        }
        return res.toString();
    }
}
