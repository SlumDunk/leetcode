package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 13:44
 * @Description: Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Leetcode202 {
    //存储出现的和值
    Set<Integer> sumSet = new HashSet<Integer>();

    public boolean isHappy(int n) {
        //利用递归来做,直到结果等于1或者重复出现
        int sum = 0;
        while (n > 0) {//求每个位置的平方和，从低位到高位
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }

        //判断和是否为1
        if (sum == 1) {
            return true;
        } else if (sumSet.contains(sum)) {//有循环
            return false;
        } else {
            sumSet.add(sum);
            return isHappy(sum);
        }
    }
}
