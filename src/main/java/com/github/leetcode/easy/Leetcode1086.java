package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:31
 * @Description: Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
public class Leetcode1086 {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            PriorityQueue<Integer> minHeap = map.get(item[0]);
            if (minHeap == null) {
                minHeap = new PriorityQueue<>();
                map.put(item[0], minHeap);
            }
            if (minHeap.size() < 5) {
                minHeap.offer(item[1]);
            } else if (minHeap.peek() < item[1]) {
                minHeap.poll();
                minHeap.offer(item[1]);
            }
        }
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (Integer id :
                map.keySet()) {
            res[idx][0] = id;
            res[idx++][1] = calculateAvg(map.get(id));
        }
        return res;
    }

    /**
     * 计算top 5的平均值
     *
     * @param heap
     * @return
     */
    private int calculateAvg(PriorityQueue<Integer> heap) {
        int sum = 0;
        int size = heap.size();
        while (!heap.isEmpty()) {
            sum += heap.poll();
        }
        return sum / size;
    }
}
