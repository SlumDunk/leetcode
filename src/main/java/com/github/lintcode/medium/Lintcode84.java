package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 11:18
 * @Description: Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 * <p>
 * Example
 * Given [1,2,2,3,4,4,5,3] return 1 and 5
 * <p>
 * Challenge
 * O(n) time, O(1) extra space.
 */
public class Lintcode84 {
    /**
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        //根据倒数第一个为1的比特位做分组
        //2n+2 的问题变成两个2n+1的问题
        //2n'+1, 2n''+1, n'+n''=n
        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((lastBit & A[i]) == 0) {
                group0 ^= A[i];
            } else {
                group1 ^= A[i];
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }
}
