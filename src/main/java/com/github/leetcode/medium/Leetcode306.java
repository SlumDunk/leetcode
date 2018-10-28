package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 11:18
 * @Description: Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 我们可以知道第一个数字的长度不应该超过字符串长度的一般，第二个数字的长度无法超过字符串长度减去第一个数字的长度。
 */
public class Leetcode306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            //如果以0开头，则只能取0作为加数
            if (num.charAt(0) == '0' && i > 1) break;
            String s1 = num.substring(0, i);
            long num1 = Long.parseLong(s1);
            for (int j = i + 1; j <= num.length() - i; j++) {
                //如果以0开头，则只能取0作为加数
                if (num.charAt(i) == '0' && j > i + 1) break;
                String s2 = num.substring(i, j);
                long num2 = Long.parseLong(s2);
                //递归判断
                if (isAdditiveNumber(num.substring(j), num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isAdditiveNumber(String num, long num1, long num2) {
        //如果剩余长度为0，说明之前都是AdditiveNumber，返回true
        if (num.length() == 0) return true;
        long add = num1 + num2;
        String adds = add + "";
        //递归判断
        return num.startsWith(adds) && isAdditiveNumber(num.substring(adds.length()), num2, add);
    }
}
