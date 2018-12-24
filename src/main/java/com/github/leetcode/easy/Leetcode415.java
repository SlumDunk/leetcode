package com.github.leetcode.easy;

import java.math.BigInteger;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Leetcode415 {
    public static void main(String[] args) {
        Leetcode415 leetcode415 = new Leetcode415();
        System.out.println(leetcode415.addStrings("9133", "0"));
    }

    public String addStrings(String num1, String num2) {
        //按位计算，从低位到高位
        //buffer字符串
        StringBuffer result = new StringBuffer();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        //存储和值
        int sum = 0;
        //存储进位
        int addition = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                sum = num1.charAt(index1) - '0' + num2.charAt(index2) - '0' + addition;
                if (sum > 9) {
                    result.append(sum % 10);
                    addition = sum / 10;
                } else {
                    result.append(sum);
                    addition = 0;
                }
                sum = 0;
                index1--;
                index2--;
            } else {
                //字符串num2已经取完了
                while (index1 >= 0) {
                    sum = num1.charAt(index1) - '0' + addition;
                    if (sum > 9) {
                        result.append(sum % 10);
                        addition = sum / 10;

                    } else {
                        result.append(sum);
                        addition = 0;
                    }
                    sum = 0;
                    index1--;
                }
                //字符串num1取完了
                while (index2 >= 0) {
                    sum = num2.charAt(index2) - '0' + addition;
                    if (sum > 9) {
                        result.append(sum % 10);
                        addition = sum / 10;

                    } else {
                        result.append(sum);
                        addition = 0;
                    }
                    sum = 0;
                    index2--;
                }
            }
        }
        //是否还有进位
        if (addition > 0) {
            result.append(addition);
        }
        //字符串翻转，变成高位到低位
        return (result.reverse()).toString();

    }
}
