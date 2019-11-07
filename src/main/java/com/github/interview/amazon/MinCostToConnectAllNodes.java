package com.github.interview.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 13:21
 * @Description:
 */
public class MinCostToConnectAllNodes {
    public static void main(String[] args) {
        MinCostToConnectAllNodes main = new MinCostToConnectAllNodes();
        int tc1 = main.minCostToConnect(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});
        if (tc1 == 7) {
            System.out.println("All Test Case Pases!");
        } else {
            System.out.println("There are test failures!");
        }
    }

    int[] parents;

    public int minCostToConnect(int n, int[][] edges, int[][] newEdges) {
        parents = new int[n + 1];
        int connected = n, minCost = 0;
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        //union已有的边
        for (int[] edge : edges) {
            if (this.union(edge[0], edge[1])) {
                connected--;
            }
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[2] - arr2[2];
            }
        });
        for (int[] newEdge : newEdges) {
            if (this.union(newEdge[0], newEdge[1])) {
                minCost += newEdge[2];
                connected--;
            }
            if (connected == 1) {
                return minCost;
            }
        }
        return connected == 1 ? connected : -1;
    }

    /**
     * union两个节点，如果本身属于同一个连通分量，那么不需要再Union,直接返回false
     *
     * @param x
     * @param y
     * @return
     */
    private boolean union(int x, int y) {
        int setX = find(x);
        int setY = find(y);
        if (setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }

    /**
     * 获取根祖先
     *
     * @param num
     * @return
     */
    private int find(int num) {
        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}
