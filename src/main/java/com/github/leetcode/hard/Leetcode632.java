package com.github.leetcode.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 10:13
 * @Description: You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * <p>
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Note:
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -105 <= value of elements <= 105.
 * For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
 */
public class Leetcode632 {
    class Node {
        /**
         * list index
         */
        int i;
        /**
         * element index within list i
         */
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int len = nums.size();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(a -> nums.get(a.i).get(a.j)));
        int cur_min = Integer.MAX_VALUE, cur_max = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            pq.add(new Node(i, 0));
            cur_min = Math.min(cur_min, nums.get(i).get(0));
            cur_max = Math.max(cur_max, nums.get(i).get(0));
        }
        int[] res = new int[2];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            cur_min = nums.get(cur.i).get(cur.j);
            if (cur_max - cur_min < diff) {
                diff = cur_max - cur_min;
                res[0] = cur_min;
                res[1] = cur_max;
            }
            if (cur.j == nums.get(cur.i).size() - 1) break;
            int next = cur.j + 1;
            cur_max = Math.max(cur_max, nums.get(cur.i).get(next));
            pq.offer(new Node(cur.i, next));
        }
        return res;
    }
}
