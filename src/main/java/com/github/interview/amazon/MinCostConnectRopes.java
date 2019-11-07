package com.github.interview.amazon;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 09:16
 * @Description:
 */
public class MinCostConnectRopes {
    public static int minCost(List<Integer> ropes) {
        Queue<Integer> pq = new PriorityQueue<>(ropes);
        int totalCost = 0;
        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            pq.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }
}
