package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 10:02
 * @Description: Given a positive integer n and you can do operations as follow:
 * <p>
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 8
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 * <p>
 * Input:
 * 7
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */
public class Leetcode397 {
    public static void main(String[] args) {
        Leetcode397 leetcode397 = new Leetcode397();
        System.out.println(leetcode397.integerReplacement(7));
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        //递归
        int count = helper(n, 0);
        return count;
    }

    /**
     * @param n     数字
     * @param count 次数
     * @return
     */
    private int helper(long n, int count) {
        //终止条件
        if (n == 1) {
            return count;
        } else if (n % 2 == 0) {//偶数
            count++;
            return helper(n / 2, count);
        } else {//奇数
            count++;
            //n+1和n-1选择路径小的
            return Math.min(helper(n + 1, count), helper(n - 1, count));
        }
    }

}
