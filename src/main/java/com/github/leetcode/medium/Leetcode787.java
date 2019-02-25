package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 2/22/19 22:19
 * @Description: There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 * <p>
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * <p>
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 * <p>
 * <p>
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 * <p>
 * <p>
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * Note:
 * <p>
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class Leetcode787 {
    /**
     * @param n:       a integer
     * @param flights: a 2D array
     * @param src:     a integer
     * @param dst:     a integer
     * @param K:       a integer
     * @return: return a integer
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int maxCost = 1 << 30;
        int[] dp = new int[n];
        Arrays.fill(dp, maxCost);
        dp[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = dp.clone();
            for (int[] flight :
                    flights) {
                temp[flight[1]] = Math.min(temp[flight[1]], dp[flight[0]] + flight[2]);
            }
            dp = temp;
        }

        return dp[dst] == maxCost ? -1 : dp[dst];
    }

    static class Pair<K, V> {

        private final K key;
        private final V value;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K element0, V element1) {
            this.key = element0;
            this.value = element1;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }

    /**
     * 广度优先搜索遍历
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int bfsFindCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //从key出发的航班列表
        Map<Integer, List<Integer>> outdegrees = new HashMap<>();

        for (int i = 0; i < flights.length; ++i) {
            if (outdegrees.containsKey(flights[i][0])) {
                outdegrees.get(flights[i][0]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                outdegrees.put(flights[i][0], list);
            }
        }

        //到达某个航班花费的钱
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int k = 0, ans = Integer.MAX_VALUE;
        if (outdegrees.get(src) != null) {
            for (int i = 0; i < outdegrees.get(src).size(); ++i) {
                queue.add(new Pair<Integer, Integer>(outdegrees.get(src).get(i), 0));
            }
        }

        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

        while (!queue.isEmpty() && k <= K) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int curr_f = queue.peek().getKey();
                int start = flights[curr_f][0];
                int end = flights[curr_f][1];
                int curr_mon = queue.peek().getValue() + flights[curr_f][2];
                queue.poll();
                if (!memo.containsKey(end)) {
                    memo.put(end, curr_mon);
                } else {
                    if (memo.get(end) <= curr_mon) {
                        continue;
                    }
                    memo.put(end, curr_mon);
                }
                if (end == dst) {
                    ans = Math.min(ans, curr_mon);
                }
                if (outdegrees.containsKey(end)) {
                    //添加边，达标从end出发的航班
                    for (int j = 0; j < outdegrees.get(end).size(); ++j) {
                        queue.add(new Pair<Integer, Integer>(outdegrees.get(end).get(j), curr_mon));
                    }
                }
            }
            k++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
