package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 21:29
 * @Description: Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 */
public class Leetcode275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len <= 0)
            return 0;
        //二分查找
        int left = 0, right = len - 1;
        //循环结束，left回到满足条件的位置
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
