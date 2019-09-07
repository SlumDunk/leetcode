package com.github.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:43
 * @Description:最大流算法 <p>
 * Edmonds-Karp 算法时Ford-Fulkerson方法的实现
 * PushRelabel
 * </p>
 */
public class MaximumFlow {

    /**
     * https://blog.csdn.net/smartxxyx/article/details/9293665
     * O(VE^2)
     */
    public static class FordFulkerson {
        /**
         * 残存网络
         */
        private double residualNetwork[][] = null;
        /**
         * 最终的流网络
         */
        private double flowNetwork[][] = null;
        int parent[];           //先驱节点

        /**
         * 实现FordFulkerson方法的一种算法——edmondsKarp算法
         *
         * @param graph
         * @param s
         * @param t
         * @return
         */
        public double edmondsKarpMaxFlow(double graph[][], int s, int t) {
            // this.N = graph.length;
            int length = graph.length;
            parent = new int[length];
            double f[][] = new double[length][length];
            //网络流
            for (int i = 0; i < length; i++) {
                Arrays.fill(f[i], 0);
            }
            //计算残余网络
            double r[][] = residualNetwork(graph, f);
            //广度优先遍历，在残余网络中寻找增广路径，也是最短增广路径，得出该路径的流
            double result = augmentPath(r, s, t);
            //最大流值
            double sum = 0;
            while (result != -1) {
                int cur = t;
                while (cur != s) {
                    //由后往前更新流网络
                    f[parent[cur]][cur] += result;
                    f[cur][parent[cur]] = -f[parent[cur]][cur];
                    //由后往前更新残余网络
                    r[parent[cur]][cur] -= result;
                    r[cur][parent[cur]] += result;
                    cur = parent[cur];
                }

                sum += result;                      //最大流更新
                result = augmentPath(r, s, t);      //广度优先遍历，在残余网络中寻找增光路径，也是最短增广路径，得出该路径的流
            }
            residualNetwork = r;
            flowNetwork = f;
            return sum;
        }

        /**
         * deepCopy     残余网络计算
         *
         * @param graph
         * @param f
         * @return
         */
        private double[][] residualNetwork(double[][] graph, double[][] f) {
            int length = graph.length;
            double r[][] = new double[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    r[i][j] = graph[i][j] - f[i][j];//残余网络=图cost-流f
                }
            }
            return r;
        }

        /**
         * 广度优先遍历，寻找增广路径，也是最短增广路径
         *
         * @param graph 残存网络
         * @param s     源节点
         * @param t     目标节点
         * @return double 没有增广路径返回-1
         */
        public double augmentPath(double graph[][], int s, int t) {

            double maxflow = Integer.MAX_VALUE;
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(s);
            parent[s] = s;

            while (!queue.isEmpty()) {
                int p = queue.poll();
                //如果到t了，则说明有了一条增广路径，则记录下该路径最小流，记为该增广路径可通过的最大流
                //回溯找路径上可通过的最小流，即为增广路径的最大流
                if (p == t) {
                    while (p != s) {
                        if (maxflow > graph[parent[p]][p])
                            maxflow = graph[parent[p]][p];
                        p = parent[p];
                    }
                } else { //记录最前面的前驱节点，如果没到最后t，且该节点没有记录过前驱节点，则记录该节点的前驱节点
                    //存在p->i的路径
                    for (int i = 0; i < graph.length; i++) {
                        if (i != p && parent[i] == -1 && graph[p][i] > 0) {//如果存在edge(p,i) 则记录parent[i]=p
                            parent[i] = p;
                            queue.add(i);
                        }
                    }
                }
            }
            if (parent[t] == -1)//如果没有遍历到t节点，则不存在增广路径，返回-1
                return -1;
            return maxflow;

        }

        /**
         * 返回残存网络
         *
         * @return
         */
        public double[][] getResidualNetwork() {
            return residualNetwork;
        }

        /**
         * 返回网络流
         *
         * @return
         */
        public double[][] getFlowNetwork() {
            return flowNetwork;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        double graph[][] = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}};
        FordFulkerson ff = new FordFulkerson();
        System.out.println(ff.edmondsKarpMaxFlow(graph, 0, 5));

    }

}
