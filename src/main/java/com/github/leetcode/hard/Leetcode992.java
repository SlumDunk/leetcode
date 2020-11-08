package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 5/12/19 23:16
 * @Description: Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.
 * <p>
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * <p>
 * Return the number of good subarrays of A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 * <p>
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
public class Leetcode992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    /**
     * 滑动窗口
     *
     * @param A
     * @param K
     * @return
     */
    private int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }

        return res;
    }


    public int subarraysWithKDistinct_(int[] A, int K) {

        return atMostK(A, K) - atMostK(A, K - 1);
    }

    /**
     * O(N)
     *
     * @param A
     * @param k
     * @return
     */
    private int atMostK_(int[] A, int k) {
        int left = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < A.length; right++) {
            if (count.getOrDefault(A[right], 0) == 0) {
                k--;
            }
            count.put(A[right], count.getOrDefault(A[right], 0) + 1);

            while (k < 0) {
                count.put(A[left], count.get(A[left]) - 1);
                if (count.get(A[left]) == 0) {
                    k++;
                }
                left++;
            }
            res += right - left + 1;
        }
        System.out.println(res);
        return res;
    }


    private int atMostK__(int[] A, int k) {
        int res = 0;
        //定义一个滑动窗口
        List<Integer> window = new ArrayList<>();
        //记录整个窗口中各个字符出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (count.getOrDefault(A[i], 0) == 0) {
                k--;
            }
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            //加入窗口
            window.add(A[i]);

            while (k < 0) {
                //移除窗口左侧的元素
                Integer val = window.remove(0);
                count.put(val, count.get(val) - 1);
                //出现次数为0, 回写k
                if (count.get(val) == 0) {
                    k++;
                }
            }
            res += window.size();
        }
        return res;
    }

}
