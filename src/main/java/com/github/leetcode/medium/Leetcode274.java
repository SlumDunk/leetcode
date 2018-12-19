package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 20:57
 * @Description: Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class Leetcode274 {
    public int hIndex(int[] citations) {
        int size = citations.length;
        if (size <= 0)
            return 0;
        //给数组排序
        Arrays.sort(citations);
        //找出h个元素的值大于等于h
        int count = 0;
        //从后往前遍历
        for (int i = size - 1; i >= 0; i--) {
            if (count >= citations[i]) {
                return count;
            } else {
                count++;
            }
        }
        return count;

    }
}
