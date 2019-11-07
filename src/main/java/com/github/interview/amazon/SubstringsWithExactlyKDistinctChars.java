package com.github.interview.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 10:55
 * @Description:
 */
public class SubstringsWithExactlyKDistinctChars {

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
    private int atMostK(int[] A, int k) {
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
}
