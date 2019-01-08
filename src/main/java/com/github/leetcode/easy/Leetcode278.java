package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/26/18 21:07
 * @Description: You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class Leetcode278 {

    public int firstBadVersion(int n) {
        int left = 1, right = n;//这里用n，不是n+1,因为返回结果是left不是-1
        while (left + 1 < right) {//[left,right]
            //(right+left)/2大数值会越界
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {//mid可能是开始坏的version,所以不能丢
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

    private boolean isBadVersion(int mid) {
        return true;
    }
}
