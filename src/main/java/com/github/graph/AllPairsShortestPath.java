package com.github.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:42
 * @Description: 多源最短路径
 */
public class AllPairsShortestPath {
    /**
     * O(n^3)
     */
    public static class Floyd {

    /*
     * 给出一个含有n个顶点的带权有向图，要求其每一对顶点之间的最短路径。
     * 这里采用佛洛依德(Floyd)最短路径算法：
     */

        private static int max = Integer.MAX_VALUE;
        private static int[][] dist = new int[6][6];                  //存储最短路径长度
        private static int[][] path = new int[6][6];                  //存储最短路径中间点信息
        /**
         * 存储某个源点到某个目标点的路径
         */
        private static ArrayList list = new ArrayList<Integer>();
        /**
         * 存储边信息
         */
        private static int[][] Arcs = {
                {max, max, 10, max, 30, 100},
                {max, max, 5, max, max, max},
                {max, max, max, 50, max, max},
                {max, max, max, max, 20, 10},
                {max, max, max, max, max, 60},
                {max, max, max, max, max, max}
        };


        /**
         * 寻找某个源点到某个目标点的最短路径
         *
         * @param begin
         * @param end
         * @param Arcs
         */
        public void findShortestPath(int begin, int end, int Arcs[][]) {
            floyd(Arcs);
            list.clear();
            list.add(begin);
            findPath(begin, end);
            list.add(end);
        }

        /**
         * 递归查找路径
         *
         * @param i
         * @param j
         */
        public void findPath(int i, int j) {
            int k = path[i][j];
            if (k == -1)
                return;
            findPath(i, k);
            list.add(k);
            findPath(k, j);
        }

        /**
         * 执行佛洛依德算法
         *
         * @param Arcs
         */
        public void floyd(int[][] Arcs) {
            int n = Arcs.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    path[i][j] = -1;                       //初始化当前的路径表
                    dist[i][j] = Arcs[i][j];                 //初始化当前的长度表
                }
            //以第k个节点为中间节点
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != max && dist[k][j] != max && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }
    }

    /**
     * 定义边类
     */
    public static class Edge {

        private int v1;
        private int v2;
        private int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public boolean equals(SingleSourceShortestPath.Edge edge) {
            return this.v1 == edge.getV1() && this.v2 == edge.getV2() && this.weight == edge.getWeight();
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getWeight() {
            return weight;
        }

        public String toString() {
            String str = "[ " + v1 + " , " + v2 + " , " + weight + " ]";
            return str;
        }

    }

    /**
     * 新增一个dummy node，和其他点都连通，weight是0
     * 先执行bellman ford算法，检测是否有负环
     * 在执行v次dijkstra算法
     * <p>
     * O(V^2lgV+VElgV)
     */
    public static class Johnson {
        static final int MAX = 20;  //最大点数
        /**
         * 存储原始图信息 边信息
         */
        static int[][] g;
        static int[] h = new int[MAX];
        //	static LinkedList<Elem> S = new LinkedList<Elem>();
        /**
         * dijkstra算法时 存储待拓展边界节点的信息
         */
        static PriorityQueue<Elem> Q = new PriorityQueue<Elem>(); //Q = V-S
        /**
         * 存储源节点到目标节点的路径
         */
        static ArrayList<Elem> nodes = new ArrayList<Elem>();
        /**
         * 存储最终的路径信息
         */
        static int[][] D;

        static int ver;  //节点数
        static int edge; //边数
        static final int BELLMAN_FORD = 1;
        static final int DIJKSTRA = 2;

        /**
         * 定义源点到目标节点的距离
         */
        static class Elem implements Comparable<Elem> {
            public int s; //节点编号
            public int d;  //与源节点距离

            public Elem(int s, int d) {
                this.s = s;
                this.d = d;
            }

            public int compareTo(Elem e) {
                return d - e.d;
            }
        }

        /**
         * 以下是Johnson算法实现
         */
        static void johnson() {

            int s = ver; //新添加一个节点
            int[][] g_new = new int[ver + 1][ver + 1];
            for (int u = 0; u < g_new.length; u++) {
                for (int v = 0; v < g_new.length; v++) {
                    if (v == g.length) {//原来图中其它节点到dummy node不可达
                        g_new[u][v] = Integer.MAX_VALUE;
                        continue;
                    }
                    if (u == g.length) {//新的dummy node到原来图中其他节点的距离为0
                        g_new[u][v] = 0;
                        continue;
                    }
                    g_new[u][v] = g[u][v];
                }
            }

            //运行bellman ford算法，查看是否存在负环
            if (bellman_ford(g_new, s) == false) {
                System.out.println("circle exist");
                return;
            }
            //从dummy node到目标节点的最短距离
            for (Elem e : nodes) h[e.s] = e.d;
            System.out.println("h[v]: from 0 to n");
            for (int i = 0; i < g.length; i++) System.out.print(h[i] + " " + '\t');
            System.out.println();
            //给所有边重新赋予权重，使其为非负 三角不等式
            for (int u = 0; u < ver; u++) {
                for (int v = 0; v < ver; v++) {
                    if (g[u][v] == Integer.MAX_VALUE) continue;
                    g[u][v] = g[u][v] + h[u] - h[v];
                }
            }
            System.out.println("G' :");
            initD(g);
            print(g);
            //执行V次dijkstra算法
            for (int u = 0; u < ver; u++) {
                dijkstra(g, u);
                for (int v = 0; v < ver; v++) {
                    if (nodes.get(v).d == Integer.MAX_VALUE) continue;
                    //做一次修正
                    D[u][v] = nodes.get(v).d + h[v] - h[u];
                }
            }

            System.out.println("D[i][j]: shortest path from i to j");
            print(D);

        }

        /**
         * 可用于Bellman-Ford与Dijkstra的初始化
         *
         * @param g
         * @param source
         * @param mode
         */
        static void init(int[][] g, int source, int mode) {
            nodes.clear();
            for (int i = 0; i < g.length; i++) {
                //初始S为空，Q为全部节点
                Elem e = new Elem(i, Integer.MAX_VALUE);
                nodes.add(e);
                if (i == source && mode == DIJKSTRA) Q.add(e);
            }
            nodes.get(source).d = 0;
        }

        /**
         * 将调整后的图信息赋予D
         *
         * @param g
         */
        static void initD(int[][] g) {
            for (int i = 0; i < g.length; i++)
                for (int j = 0; j < g.length; j++) {
                    D[i][j] = g[i][j];
                }
        }

        /**
         * 以下是Bellman-Ford实现
         *
         * @param g
         * @param source
         * @return
         */
        static boolean bellman_ford(int[][] g, int source) {
            init(g, source, BELLMAN_FORD);
            int s = 0, e = 0, w = 0;
            //对所有边进行n-1次松弛操作
            for (int i = 0; i < g.length - 1; i++) {
                //对所有的边进行松弛操作
                for (int u = 0; u < g.length; u++) {
                    for (int v = 0; v < g.length; v++) {
                        if (g[u][v] == Integer.MAX_VALUE || nodes.get(u).d == Integer.MAX_VALUE) continue;
                        nodes.get(v).d = Math.min(nodes.get(v).d, nodes.get(u).d + g[u][v]);
                    }
                }
            }
            //遍历每条边
            for (int u = 0; u < g.length; u++) {
                for (int v = 0; v < g.length; v++) {
                    if (g[u][v] == Integer.MAX_VALUE || nodes.get(u).d == Integer.MAX_VALUE) continue;
                    if (nodes.get(v).d > nodes.get(u).d + g[u][v]) return false;
                }
            }
            return true;
        }

        /**
         * 以下是Dijkstra实现
         *
         * @param g
         * @param source
         */
        static void dijkstra(int[][] g, int source) {
            init(g, source, DIJKSTRA);
            while (Q.size() > 0) {
                Elem prev = Q.poll();
//		    S.add(u);
                for (int v = 0; v < g.length; v++) {
                    if (g[prev.s][v] != Integer.MAX_VALUE && nodes.get(v).d > prev.d + g[prev.s][v]) {
                        Elem nv = nodes.get(v);
                        //下面删除后添加是为了使PriorityQueue能够重新调整
                        Q.remove(nv);
                        nv.d = prev.d + g[prev.s][v];
                        Q.offer(nv);
                    }
                }
            }
        }

        /**
         * 用于获取输入数据，初始化图G
         */
        static void input() {
            Scanner cin = new Scanner(System.in);
            System.out.println("请输入 点数 边数");
            ver = cin.nextInt();
            edge = cin.nextInt();
            g = new int[ver][ver];
            D = new int[ver + 1][ver + 1];
            int s, e, w;
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < ver; j++) {
                    g[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println("起点 终点 权值");
            for (int i = 0; i < edge; i++) {
                s = cin.nextInt();
                e = cin.nextInt();
                w = cin.nextInt();
                g[s][e] = w;
            }
        }

        /**
         * 打印前驱矩阵
         *
         * @param g
         */
        static void print(int[][] g) {
            for (int u = 0; u < ver; u++) {
                for (int v = 0; v < ver; v++) {
                    if (g[u][v] == Integer.MAX_VALUE) {
                        System.out.print("inf\t");
                        continue;
                    }
                    System.out.print(g[u][v] + "" + '\t');
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Floyd f = new Floyd();
        for (int i = 0; i < Floyd.Arcs.length; i++) {
            for (int j = 0; j < Floyd.Arcs.length; j++) {
                f.findShortestPath(i, j, Floyd.Arcs);
                ArrayList<Integer> L = f.list;
                System.out.print(i + "-->" + j + ":");
                if (f.dist[i][j] == Floyd.max) {
                    System.out.println("之间没有最短路径");
                    System.out.println();
                } else {
                    System.out.println("的最短路径是：");
                    System.out.print(L.toString() + " ");
                    System.out.println("路径长度:" + f.dist[i][j]);
                    System.out.println();
                }
            }
        }
        Johnson johnson = new Johnson();
        johnson.input();
        johnson.johnson();
    }
}
