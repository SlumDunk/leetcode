package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 21:09
 * @Description: Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 * <p>
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * <p>
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * <p>
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 * <p>
 * Example 1:
 * <p>
 * Input: "123456579"
 * Output: [123,456,579]
 * Example 2:
 * <p>
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * Example 3:
 * <p>
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * Example 4:
 * <p>
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 * <p>
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S contains only digits.
 */
public class Leetcode842 {
    List<Integer> result;

    /**
     * @param current 当前组成的数列
     * @param S
     * @param index
     */
    public void traverse(List<Integer> current, String S, int index) {
        // 3. The sequence should has at least 3 elements
        if (index == S.length() && current.size() > 2) {
            result = new ArrayList<Integer>(current);
        } else {
            for (int i = index; i < S.length(); i++) {
                // 1. Remove elements with leading zero
                if (S.charAt(index) == '0' && i + 1 - index > 1)
                    break;

                long longValue = Long.parseLong(S.substring(index, i + 1));
                // 2. The element in the sequence should be at most Integer.MAX_VALUE
                if (longValue > Integer.MAX_VALUE)
                    break;
                int size = current.size();
                if (current.size() < 2) {
                    current.add((int) longValue);
                    traverse(current, S, i + 1);
                    // 5. If we find a valid sequence, stop backtracking
                    if (result != null)
                        break;
                    current.remove(current.size() - 1);
                } else {
                    long sum = (long) current.get(size - 1) + (long) current.get(size - 2);
                    // 4. If current number is larger than the sum of previous two elements, stop backtracking
                    if (longValue > sum)
                        break;
                    else if (longValue < sum)
                        continue;
                    else {
                        current.add((int) longValue);
                        traverse(current, S, i + 1);
                        if (result != null)
                            break;
                        current.remove(current.size() - 1);
                    }
                }
            }
        }
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> current = new ArrayList<Integer>();
        traverse(current, S, 0);
        return result != null ? result : new ArrayList<Integer>();
    }
}
