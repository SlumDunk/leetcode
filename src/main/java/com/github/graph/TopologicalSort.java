package com.github.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:37
 * @Description:拓扑排序 依赖分析问题 寻找critical path 有向无环图
 * <p>
 * 初始化一个int[] inDegree保存每一个结点的入度。
 * 对于图中的每一个结点的子结点，将其子结点的入度加1。
 * 选取入度为0的结点开始遍历，并将该节点加入输出。
 * 对于遍历过的每个结点，更新其子结点的入度：将子结点的入度减1。
 * 重复步骤3，直到遍历完所有的结点。
 * 如果无法遍历完所有的结点，则意味着当前的图不是有向无环图。不存在拓扑排序。
 * <p>
 * O(V+E)
 */
public class TopologicalSort {
    /**
     * @param n             n个节点 0到n-1编号
     * @param adjacencyList 邻接矩阵
     * @return
     */
    public List<Integer> topologicalSort(int n, int[][] adjacencyList) {
        //结果list
        List<Integer> resultList = new ArrayList<>();
        //构造节点的入度
        int[] inDegree = new int[n];
        for (int[] parent : adjacencyList) {
            for (int child : parent) {
                inDegree[child]++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();

        // start from nodes whose in-degree are 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) deque.offer(i);
        }

        while (!deque.isEmpty()) {
            int curr = deque.poll();
            resultList.add(curr);
            for (int child : adjacencyList[curr]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }

        return resultList.size() == n ? resultList : new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
