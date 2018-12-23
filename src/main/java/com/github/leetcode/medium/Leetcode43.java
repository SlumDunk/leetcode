package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 12:02
 * @Description: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Leetcode43 {
    public String multiply(String num1, String num2) {
        //两个string转为int数组
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";

        //按位进行计算
        int[] add1 = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++)
            add1[i] = Integer.parseInt(num1.substring(i, i + 1));
        int[] add2 = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++)
            add2[i] = Integer.parseInt(num2.substring(i, i + 1));
        int[] result = new int[num1.length() + num2.length() - 1];

        //进行每一位的相乘
        for (int i = 0; i < add1.length; i++)
            for (int j = 0; j < add2.length; j++)
                result[i + j] += add1[i] * add2[j];

        //低位到高位的进位
        int numx = 0;
        String rs = "";
        //反向更新数组的值，并转为string
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] += numx;
            //新的进位
            numx = result[i] / 10;
            //当前位的值
            result[i] = result[i] % 10;
            //字符串拼接
            rs = String.valueOf(result[i]) + rs;
        }

        //最后进位大于0
        if (numx > 0)
            rs = String.valueOf(numx) + rs;
        int index = 0;
        //找到结果非0开始位置
        while (index < rs.length() && rs.charAt(index) == '0') {
            index++;
        }
        if (index > 0) {
            return rs.substring(index - 1, rs.length());
        } else {
            return rs.substring(index, rs.length());
        }
    }


}
