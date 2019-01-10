package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 11:09
 * @Description:
 */
public class Lintcode74 {

    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        } else {
            return right;
        }
    }

    private boolean isBadVersion(int left) {
        return false;
    }
}
