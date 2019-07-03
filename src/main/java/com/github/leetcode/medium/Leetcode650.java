package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 07:18
 * @Description: Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * <p>
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * <p>
 * <p>
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * <p>
 * <p>
 * Note:
 * <p>
 * The n will be in the range [1, 1000].
 */
public class Leetcode650 {
    public int minSteps(int n) {
        int result = 0;
        while (n > 1) {
            //从后往前推
            //遍历需要复制的次数,优先处理小的
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    result += i;
                    n /= i;//每一步复制的大小
                    break;
                }
            }
        }
        return result;
    }
}
