package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 17:10
 * @Description: We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 * <p>
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
 * <p>
 * Example:
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation:
 * The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * Note:
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 */
public class Leetcode815 {

    /**
     * O(n*m) n is the number of routes, m is the average number of stops for each routes
     *
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || S == T) return 0;
        //站为key, 站关联的route集合为value
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) map.put(stop, new HashSet<Integer>());
                map.get(stop).add(i);
            }
        }

        HashSet<Integer> visited = new HashSet<Integer>(); // visited routes
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int route : map.get(S)) {
            queue.add(route);
            visited.add(route);
        }

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int routeId = queue.poll();
                int[] stops = routes[routeId];
                for (int stop : stops) {
                    if (stop == T) return step;
                    for (int route : map.get(stop)) {
                        if (!visited.contains(route)) {
                            queue.add(route);
                            visited.add(route);
                        }
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }
}
