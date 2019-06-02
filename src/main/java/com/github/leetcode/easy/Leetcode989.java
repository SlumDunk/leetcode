package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 11:39
 * @Description: For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
 * <p>
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 * <p>
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 * <p>
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 * <p>
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * Note：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
public class Leetcode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int flag = 0;
        for (int i = A.length - 1; i >= 0; --i) {
            if (K >= 0) {
                int temp = A[i] + K % 10 + flag;
                if (temp > 9) {
                    ans.add(temp % 10);
                    flag = 1;
                } else {
                    flag = 0;
                    ans.add(temp);
                }
                K /= 10;
            } else ans.add(A[i]);
        }

        while (K > 0) {
            System.out.print(K % 10 + "\n");
            if (K % 10 + flag > 9) {
                ans.add((K % 10 + flag) % 10);
                flag = 1;
            } else {
                ans.add(K % 10 + flag);
                flag = 0;
            }
            K /= 10;
        }

        if (flag == 1) ans.add(1);

        Collections.reverse(ans);
        return ans;
    }
}
