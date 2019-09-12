package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 13:18
 * @Description: Implementing the class MajorityChecker, which has the following API:
 * <p>
 * MajorityChecker(int[] arr) constructs an instance of MajorityChecker with the given array arr;
 * int query(int left, int right, int threshold) has arguments such that:
 * 0 <= left <= right < arr.length representing a subarray of arr;
 * 2 * threshold > right - left + 1, ie. the threshold is always a strict majority of the length of the subarray
 * Each query(...) returns the element in arr[left], arr[left+1], ..., arr[right] that occurs at least threshold times, or -1 if no such element exists.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
 * majorityChecker.query(0,5,4); // returns 1
 * majorityChecker.query(0,3,3); // returns -1
 * majorityChecker.query(2,3,2); // returns 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 20000
 * 1 <= arr[i] <= 20000
 * For each query, 0 <= left <= right < len(arr)
 * For each query, 2 * threshold > right - left + 1
 * The number of queries is at most 10000
 */
public class Leetcode1157 {

    class MajorityChecker {
        /**
         * key为数组中某个元素值 value为该值出现的位置list
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arr;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        /**
         * 出现的频率
         * 1 3 4 6 8 9
         * left 5 -> index 4
         * right 10-> index 7
         *
         * @param left
         * @param right
         * @param a
         * @return
         */
        private int getOccurrence(int left, int right, int a) {
            List<Integer> list = map.get(a);
            //-(insertion  point -1)
            int i = Collections.binarySearch(list, left);
            if (i < 0) i = ~i;
            //left的insertion point得出现在最后一个位置
            if (i == list.size()) return 0;
            int j = Collections.binarySearch(list, right);
            //真实预计要插入的位置
            if (j < 0) j = ~j;
            return j-1 - i-1 + 1;
        }

        /**
         * 随机获取一个位置值
         * @param l
         * @param r
         * @return
         */
        private int getRandomNum(int l, int r) {
            Random rand = new Random();
            return rand.nextInt(r - l + 1) + l;
        }

        public int query(int left, int right, int threshold) {
            for (int i = 0; i < 10; i++) {
                int a = arr[getRandomNum(left, right)];
                if (getOccurrence(left, right, a) >= threshold)
                    return a;
            }
            return -1;
        }
    }
}
