package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 17:05
 * @Description: There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 * <p>
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * <p>
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, m = 1.
 * Output: 4
 * Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 * <p>
 * <p>
 * Note: n and m both fit in range [0, 1000].
 */
public class Leetcode672 {
    /**
     * for n > 3, result is same as n = 3, if same series of operations apply on 3 bulbs generate k distinct result, apply them on more than 3 bulbs would also generate k distinct result.
     * only even and odd matters for each operation. So the total possible op series would be [0,0,0,0], [0,0,0,1]...to [1,1,1,1], 16 total
     * order of operations doesn't matter
     * bfs+memory
     *
     * @param n
     * @param m
     * @return
     */
    public int flipLights(int n, int m) {
        StringBuilder status = new StringBuilder();
        /**
         * 记忆化搜索
         */
        Map<String, String[]> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            status.append(1);
        }
        Queue<String> current = new LinkedList<>();
        current.offer(status.toString());
        for (int i = 0; i < m; i++) {
            Set<String> nextElements = new HashSet<>();
            while (current.peek() != null) {
                String cs = current.poll();
                if (memo.containsKey(cs)) {
                    for (int j = 0; j < 4; j++) {
                        nextElements.add(memo.get(cs)[j]);
                    }
                } else {
                    //all
                    char[] c1 = cs.toCharArray();
                    //even
                    char[] c2 = cs.toCharArray();
                    //odd
                    char[] c3 = cs.toCharArray();
                    //3k+1
                    char[] c4 = cs.toCharArray();
                    for (int j = 0; j < n; j++) {
                        c1[j] = flip(c1[j]);
                        if (j % 2 == 0) {
                            c2[j] = flip(c2[j]);
                        }
                        if (j % 2 == 1) {
                            c3[j] = flip(c3[j]);
                        }
                        if (j % 3 == 0) {
                            c4[j] = flip(c4[j]);
                        }
                    }
                    String s1 = new String(c1);
                    String s2 = new String(c2);
                    String s3 = new String(c3);
                    String s4 = new String(c4);

                    nextElements.add(s1);
                    nextElements.add(s2);
                    nextElements.add(s3);
                    nextElements.add(s4);
                    String[] temp = {s1, s2, s3, s4};
                    memo.put(cs, temp);
                }
            }
            for (String str : nextElements) {
                current.offer(str);
            }
        }
        return current.size();
    }

    /**
     * 翻转数字
     *
     * @param i
     * @return
     */
    private char flip(char i) {
        if (i == '1') return '0';
        else return '1';
    }
}
