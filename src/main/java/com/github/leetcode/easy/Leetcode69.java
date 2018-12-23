package com.github.leetcode.easy;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class Leetcode69 {
    public int mySqrt(int x) {
        //在0到x/2之间,利用二分搜索
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            //注意x/mid>mid和x>mid*mid是有区别的
            if (x / mid >= mid) left = mid + 1;//保证最终的right比根号值要大1
            else right = mid;
        }

        return right - 1;
    }
}
