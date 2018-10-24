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
        k--; // to translate index from 0 rather than 1
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        int round = n - 1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0) {
            sb.append(list.remove(k / factorial));//new list
            k %= factorial;//new k
            if (round != 0) factorial /= round;//new factorial
            round--;// new round
        }
        return sb.toString();
    }
}
