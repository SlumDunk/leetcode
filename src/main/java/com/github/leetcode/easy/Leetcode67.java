package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 20:07
 * @Description:
 */
public class Leetcode67 {
    public String addBinary(String a, String b) {
        //从低位开始加，逢2进1
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        //进位
        int add = 0;
        int factor1 = 0;
        int factor2 = 0;
        int sum = 0;
        StringBuilder buffer = new StringBuilder("");
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0 && indexB >= 0) {//两个字符串都没走完
                factor1 = a.charAt(indexA) - '0';
                factor2 = b.charAt(indexB) - '0';
                sum = factor1 + factor2 + add;
                buffer.append(sum % 2);
                add = sum / 2;
                indexA--;
                indexB--;
            } else if (indexA >= 0) {//a字符串还没走完
                factor1 = a.charAt(indexA) - '0';
                sum = factor1 + add;
                buffer.append(sum % 2);
                add = sum / 2;
                indexA--;
            } else {//b字符串还没走完
                factor2 = b.charAt(indexB) - '0';
                sum = factor2 + add;
                buffer.append(sum % 2);
                add = sum / 2;
                indexB--;
            }
        }
        //看看最终进位是否为0
        if (add > 0) {
            buffer.append(add);
        }

        return buffer.reverse().toString();

    }
}
