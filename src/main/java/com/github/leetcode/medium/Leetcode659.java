package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 09:45
 * @Description: You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.
 * <p>
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * Example 2:
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 * Note:
 * The length of the input is in range of [1, 10000]
 */
public class Leetcode659 {
    public static void main(String[] args) {
        Leetcode659 leetcode659 = new Leetcode659();
        leetcode659.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
    }

    class Pair implements Comparable<Pair> {
        /**
         * 末尾元素
         */
        int end;
        /**
         * 分组长度
         */
        int size;

        public Pair(int end, int size) {
            this.end = end;
            this.size = size;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.end == p.end) {//如果尾部值相同，优先取出分组长度短的
                return this.size - p.size;
            } else {//否则，有限取出末尾值小的
                return this.end - p.end;
            }
        }
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            //非连续，判断分组长度是否大于等于3
            while (!pq.isEmpty() && pq.peek().end + 1 < nums[i]) {
                if (pq.poll().size < 3) return false;
            }

            if (pq.isEmpty()) {//队列为空，直接入队
                pq.offer(new Pair(nums[i], 1));
                continue;
            }

            Pair p = pq.peek();
            if (p.end == nums[i] || p.end + 1 < nums[i]) {
                pq.offer(new Pair(nums[i], 1));
            } else {
                pq.offer(new Pair(nums[i], pq.poll().size + 1));
            }
        }

        while (!pq.isEmpty()) {//判断是否有漏
            if (pq.poll().size < 3) return false;
        }

        return true;
    }
}
