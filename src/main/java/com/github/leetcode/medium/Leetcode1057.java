package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 23:28
 * @Description: On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 * <p>
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.
 * <p>
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 * <p>
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * Explanation:
 * Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: [0,2,1]
 * Explanation:
 * Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= workers[i][j], bikes[i][j] < 1000
 * All worker and bike locations are distinct.
 * 1 <= workers.length <= bikes.length <= 1000
 */
public class Leetcode1057 {
    int[][] workers, bikes;

    public int[] assignBikes(int[][] workers, int[][] bikes) {

        int[] ans = new int[workers.length];
        Set<Integer> usedBikes = new HashSet<>();
        this.workers = workers;
        this.bikes = bikes;
        //位置索引代表员工编号
        List<Queue<int[]>> qlist = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            Queue<int[]> q = new PriorityQueue<>((p1, p2) ->
                    dist(p1) != dist(p2) ? Integer.compare(dist(p1), dist(p2)) : Integer.compare(p1[1], p2[1]));
            for (int j = 0; j < bikes.length; j++)
                q.add(new int[]{i, j});
            qlist.add(q);
        }

        //若距离一致，按照员工编号先后顺序排列
        Queue<Integer> qall = new PriorityQueue<>((a, b) ->
                dist(qlist.get(a).peek()) != dist(qlist.get(b).peek()) ? Integer.compare(dist(qlist.get(a).peek()),
                        dist(qlist.get(b).peek())) : Integer.compare(a, b));
        for (int i = 0; i < qlist.size(); i++)
            qall.add(i);

        while (!qall.isEmpty()) {
            int wid = qall.poll();
            int[] pair = qlist.get(wid).poll();
            if (usedBikes.contains(pair[1])) {//已经使用过了
                qall.add(wid);
            }else {
                usedBikes.add(pair[1]);
                ans[wid] = pair[1];
            }
        }

        return ans;
    }

    /**
     * 返回这对组合的距离
     * @param pair
     * @return
     */
    public int dist(int[] pair) {
        int[] worker = workers[pair[0]];
        int[] bike = bikes[pair[1]];

        int d = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
        return d;
    }
}
