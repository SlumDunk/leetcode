package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 14:27
 * @Description: The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class Leetcode60 {
    public String getPermutation(int n, int k) {
        //因为每一位内部都有顺序可循，从高位定位到低位
        k--; //将位置指针转化为从0开始的
        List<Integer> list = new ArrayList<Integer>();
        //参与排列组合的数字
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //factorial 从(n-1)!开始，因为第一位后面有(n-1)!种变化
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }

        //第一位后面有n-1位，所以有(n-1)!种变化
        int round = n - 1;
        StringBuilder buffer = new StringBuilder("");
        //因为第一位的数字总是从小到大
        //从高位定位到低位
        while (round >= 0) {
            buffer.append(list.remove(k / factorial));
            k = k % factorial;
            if (round > 0) factorial /= round;
            round--;
        }
        return buffer.toString();
    }
}
