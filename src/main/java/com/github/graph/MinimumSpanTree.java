package com.github.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:40
 * @Description: 最小生成树
 * 图涉及到边的权重
 */
public class MinimumSpanTree {
    /**
     * 带权重的边的类
     */
    static class Edge {
        public int start;//始边
        public int end;//终边
        public double cost;//权重
    }

    /**
     * 克鲁斯卡尔算法求最小生成树
     * 从边出发，找最小连通分量
     * <p>
     * 先将所有边进行权值的从小到大排序
     * 每次都找最小一条边
     * 检测回路
     * 结果是有n-1条边
     * <p>
     * <p>
     * <p>
     * 1).记Graph中有v个顶点，e个边
     * <p>
     * 2).新建图Graphnew，Graphnew中拥有原图中相同的e个顶点，但没有边
     * <p>
     * 3).将原图Graph中所有e个边按权值从小到大排序
     * <p>
     * 4).循环：从权值最小的边开始遍历每条边 直至图Graph中所有的节点都在同一个连通分量中
     * <p>
     * if 这条边连接的两个节点于图Graphnew中不在同一个连通分量中
     * <p>
     * 添加这条边到图Graphnew中
     * <p>
     * O(ElgV)
     */
    public static class KruskalMST {
        private int MAX = 100;
        private ArrayList<Edge> listEdge = new ArrayList<Edge>();//整个图的边
        private ArrayList<Edge> target = new ArrayList<Edge>();//目标边，最小生成树
        private int[] parent = new int[MAX];//标志所在的集合
        private double INFINITY = Double.MAX_VALUE;//定义无穷大
        private double minCost = 0.0;//最小成本
        private int n;//结点个数

        //初始化
        public void init() {
            Scanner scan = new Scanner(System.in);
            int startVertex, endVertex;
            double w;

            System.out.println("spanning tree begin!Input the node number:");
            n = scan.nextInt();
            System.out.println("Input the graph(-1,-1,-1 to exit)");

            while (true) {
                startVertex = scan.nextInt();
                endVertex = scan.nextInt();
                w = scan.nextDouble();
                if (startVertex < 0 || endVertex < 0 || w < 0) {
                    break;
                }
                Edge e = new Edge();
                e.start = startVertex;
                e.end = endVertex;
                e.cost = w;
                listEdge.add(e);
            }

            //初始化当前节点所属的分组
            for (int i = 1; i <= n; ++i) {
                parent[i] = i;
            }
            scan.close();
        }

        /**
         * 合并两个集合
         *
         * @param j 以j为祖先的集合
         * @param k 以k为祖先的集合
         */
        public void union(int j, int k) {
            for (int i = 1; i <= n; ++i) {
                if (parent[i] == j) {
                    parent[i] = k;
                }
            }
        }

        /**
         * 执行克鲁斯卡尔算法
         */
        public void kruskal() {
            //最小生成树有n-1条边
            int i = 0;
            while (i < n - 1 && listEdge.size() > 0) {
                //每次寻找剩下的边里头权重最小的那条边
                double minWeight = INFINITY;
                Edge tmp = null;
                for (int j = 0; j < listEdge.size(); ++j) {
                    Edge edge = listEdge.get(j);
                    if (edge.cost < minWeight) {
                        minWeight = edge.cost;
                        tmp = edge;
                    }
                }
                int parentStart = parent[tmp.start];
                int parentEnd = parent[tmp.end];
                //去掉环，判断当前这条边的两个端点是否属于同一棵树
                if (parentStart != parentEnd) {
                    ++i;
                    target.add(tmp);
                    minCost += tmp.cost;
                    union(parentStart, parentEnd);
                }
                listEdge.remove(tmp);
            }
            if (i != n - 1) {
                System.out.println("no spanning tree");
            }
        }

        //打印结果
        public void print() {
            for (int i = 0; i < target.size(); ++i) {
                Edge e = target.get(i);
                System.out.println("the " + (i + 1) + "th listEdge:" + e.start + "---" + e.end + "   cost:" + e.cost);
            }
            System.out.println("the MST cost:" + minCost);
        }
    }

    /**
     * 普利姆算法求最小生成树
     * 从点到面
     * <p>
     * 从图里选取n个节点和n-1条边，开始条件，任选一个节点，将它的最小的邻边节点纳入集合中，再拓展当前集合对外课接触到的节点，重复以上动作
     * <p>
     * 1).输入：一个加权连通图，其中顶点集合为V，边集合为E；
     * <p>
     * 2).初始化：Vnew = {x}，其中x为集合V中的任一节点（起始点），Enew = {},为空；
     * <p>
     * 3).重复下列操作，直到Vnew = V：
     * <p>
     * a.在集合E中选取权值最小的边<u, v>，其中u为集合Vnew中的元素，而v不在Vnew集合当中，并且v∈V（如果存在有多条满足前述条件即具有相同权值的边，则可任意选取其中之一）；
     * <p>
     * b.将v加入集合Vnew中，将<u, v>边加入集合Enew中；
     * <p>
     * 4).输出：使用集合Vnew和Enew来描述所得到的最小生成树。
     * <p>
     */
    public static class PrimMST {
        private static int MAX = 100;
        /**
         * 二维数组存放图
         */
        private static int[][] graph = new int[MAX][MAX];
        /**
         * 当前可达的点的成本，0表示不可达或已经纳入目标树
         */
        private int[] lowCost = new int[MAX];
        /**
         * 目标节点的出发节点
         */
        private int[] parent = new int[MAX];
        /**
         * 定义无穷大
         */
        private static int INFINITY = Integer.MAX_VALUE;
        /**
         * 最小成本
         */
        private int minCost = 0;
        /**
         * 结点个数
         */
        int n;
        /**
         * 下一步要拓展的节点
         */
        private int target;
        private int sum = 0;

        /**
         * 初始化图
         */
        public void init() {
            Scanner scan = new Scanner(System.in);
            int p, q, w;
            System.out.println("spanning tree begin!Input the node number:");
            n = scan.nextInt();
            System.out.println("Input the graph(-1,-1,-1 to exit)");
            while (true) {
                p = scan.nextInt();
                q = scan.nextInt();
                w = scan.nextInt();
                if (p < 0 || q < 0 || w < 0) {
                    break;
                }
                graph[p][q] = w;
                graph[q][p] = w;
            }
            scan.close();
        }

        /**
         * 普利姆算法
         * O(V^2)
         *
         * @return
         */
        public int prim() {
            //取1节点为我们的出发节点
            for (int i = 2; i <= n; i++) {
                lowCost[i] = graph[1][i];
                parent[i] = 1;
            }
            parent[1] = 0;
            //结束条件，找到n-1条边 n-2+1
            for (int i = 2; i <= n; i++) {
                minCost = INFINITY;
                target = 0;
                //找拓展成本最小的边
                for (int j = 0; j <= n; j++) {
                    //当前集合可达且拓展成本小于当前成本的边
                    if (lowCost[j] < minCost && lowCost[j] != 0) {
                        minCost = lowCost[j];
                        target = j;
                    }
                }
                System.out.println(parent[target] + "--" + target + "==" + minCost);
                sum += minCost;
                //置位0，表示已经纳入当前树
                lowCost[target] = 0;
                //更新待访问节点的访问成本
                for (int j = 0; j <= n; j++) {
                    if (graph[target][j] < lowCost[j]) {
                        lowCost[j] = graph[target][j];
                        parent[j] = target;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String args[]) {
        KruskalMST sp = new KruskalMST();
        sp.init();
        sp.kruskal();
        sp.print();

        PrimMST primMST = new PrimMST();
        primMST.init();
        double mstcost = primMST.prim();
        System.out.println("最小生成树权值和为：" + mstcost);
    }
}
