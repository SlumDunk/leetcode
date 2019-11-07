package com.github.lintcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 17:34
 * @Description:
 */
public class Lintcode139 {
    /**
     * 前k个数的和
     */
    class Pair {
        int sum;
        int count;

        public Pair(int s, int i) {
            sum = s;
            count = i;
        }
    }

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the count of the first number and the count of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        if (len == 1) {
            result[0] = result[1] = 0;
            return result;
        }
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        //前0个数之和为0
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }

        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].count - 1, sums[i - 1].count - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;//开闭区间
                result[1] = temp[1];
            }
        }

        return result;
    }


    /*
    * @param nums: A list of integers
    * @return: A list of integers includes the index of the first number and the index of the last number
    */
    public int[] subarraySumClosest_(int[] nums) {
        // write your code here
        int[] result = new int[2];

        if (nums == null || nums.length == 0) {
            return result;
        }

        int len = nums.length;
        if (len == 1) {
            result[0] = result[1] = 0;
            return result;
        }

        Pair_[] prefixSum = new Pair_[len + 1];
        prefixSum[0] = new Pair_(0, 0);
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = new Pair_(prefixSum[i - 1].sum + nums[i - 1], i);
        }

        Arrays.sort(prefixSum, new Comparator<Pair_>() {
                    public int compare(Pair_ a, Pair_ b) {
                        if (a.sum != b.sum) {
                            return a.sum - b.sum;
                        } else {
                            return a.idx - b.idx;
                        }
                    }
                }
        );

        int diff = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            int cur = prefixSum[i].sum - prefixSum[i - 1].sum;
            if (diff > cur) {
                diff = cur;
                int[] temp = new int[]{prefixSum[i].idx - 1, prefixSum[i - 1].idx - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];
            }
        }
        return result;
    }

    class Pair_ {
        int sum;
        int idx;

        public Pair_(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }
}
