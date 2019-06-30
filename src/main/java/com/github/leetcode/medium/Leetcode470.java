package com.github.leetcode.medium;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 09:28
 * @Description: Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * <p>
 * Do NOT use system's Math.random().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: [7]
 * Example 2:
 * <p>
 * Input: 2
 * Output: [8,4]
 * Example 3:
 * <p>
 * Input: 3
 * Output: [8,1,10]
 * <p>
 * <p>
 * Note:
 * <p>
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 */
public class Leetcode470 {
    public int rand10() {
        int index = Integer.MAX_VALUE;
        while (index >= 40) {
            index = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return index % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}
