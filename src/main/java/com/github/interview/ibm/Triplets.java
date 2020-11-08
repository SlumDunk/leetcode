package com.github.interview.ibm;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 19:14
 * @Description:
 */
public class Triplets {
    /**
     * d[a]<d[b]<d[c]
     * d[a]+d[b]+d[c]<=t
     * <p>
     * d=[1,2,3,4,6]
     * t=8
     * 3
     *
     * @param t
     * @param d
     * @return
     */
    static long triplets(long t, List<Integer> d) {
        Collections.sort(d);
        if (d.size() < 3) {
            return 0;
        } else {
            long count = 0;
            int start = 0;
            int n = d.size();
            Map<String, Long> cache = new HashMap<>();
            while (start < n - 2) {
                if (d.get(start) >= t) {
                    break;
                }
                int end = start + 1;
                while (end < n - 1) {
                    long preSum = d.get(start) + d.get(end);
                    if (preSum >= t) {
                        break;
                    } else {
                        int k = end + 1;
                        long left = t - preSum;
                        while (k < n) {
                            if (d.get(k) <= left) {
                                count++;
                            } else {
                                break;
                            }
                            k++;
                        }
                    }
                    end++;
                }
                start++;
            }
            return count;
        }
    }

    static long tripletsOptimization(long t, List<Integer> d) {
        Collections.sort(d);
        if (d.size() < 3) {
            return 0;
        } else {
            long count = 0;
            int n = d.size();
            for (int i = 0; i < n - 2; i++) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    if (d.get(i) + d.get(j) + d.get(k) > t) {
                        k--;
                    } else {
                        count += (k - j);
                        j++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(6);
        System.out.println(triplets(8, d));
        System.out.println(tripletsOptimization(8, d));
    }
}
