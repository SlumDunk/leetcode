package com.github.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:41
 * @Description: 单源最短路径
 * 地杰斯特拉算法和贝尔曼福特算法
 * Dijkstra要求图中不存在边权值之和为负数的环路，否则算法无法收敛；
 * Bellman-Ford算法可以检测出图中是否存在权值之和为负数的环路。
 */
public class SingleSourceShortestPath {
    public static class Graph {
        private int vertexSize;//顶点数量

        public int getVertexSize() {
            return vertexSize;
        }


        public void setVertexSize(int vertexSize) {
            this.vertexSize = vertexSize;
        }

        private int[] vertexs;//顶点数组
        /**
         * 用邻接矩阵存储图的结构
         */
        private int[][] matrix;

        public int[][] getMatrix() {
            return matrix;
        }


        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        /**
         * 表示不可达节点的权重
         */
        public static final int MAX_WEIGHT = 1000;
        private boolean[] isVisited;

        public Graph(int vertextSize) {
            this.vertexSize = vertextSize;
            matrix = new int[vertextSize][vertextSize];
            vertexs = new int[vertextSize];
            for (int i = 0; i < vertextSize; i++) {
                vertexs[i] = i;
            }
            isVisited = new boolean[vertextSize];
        }

        /**
         * 创建图的过程
         */
        public void createGraph() {
            int[] a1 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a2 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a3 = new int[]{5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a4 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
            int[] a5 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
            int[] a6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
            int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
            int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
            int[] a9 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};

            matrix[0] = a1;
            matrix[1] = a2;
            matrix[2] = a3;
            matrix[3] = a4;
            matrix[4] = a5;
            matrix[5] = a6;
            matrix[6] = a7;
            matrix[7] = a8;
            matrix[8] = a9;
        }
    }

    /**
     * 迪杰斯特拉算法
     * O(n^2)
     */
    public static class Dijkstra {
        private final static int MAXVEX = 9;
        private final static int MAXWEIGHT = 1000;
        /**
         * 记录的是V0到某顶点的最短路径值
         */
        private int shortTablePath[] = new int[MAXVEX];

        public void shortestPathDijkstra(Graph graph) {
            int min;
            //记录每次要加进来的点的下标
            int k = 0;
            //标记是否从源节点到当前节点的路径
            boolean isGetPath[] = new boolean[MAXVEX];

            //初始化shortTablePath
            shortTablePath = graph.getMatrix()[0];
            shortTablePath[0] = 0;
            isGetPath[0] = true;

            for (int v = 1; v < graph.getVertexSize(); v++) {
                min = MAXWEIGHT;

                //寻找可拓展的边中的最短路径
                for (int i = 0; i < graph.getVertexSize(); i++) {
                    if (!isGetPath[i] && shortTablePath[i] < min) {
                        k = i;
                        min = shortTablePath[i];
                    }
                }

                //标志k的位置当前是最短路径
                isGetPath[k] = true;

                // 更新源节点到未访问节点的最短路径
                for (int j = 0; j < graph.getVertexSize(); j++) {

                    if (!isGetPath[j] && (min + graph.getMatrix()[k][j]) < shortTablePath[j]) {
                        shortTablePath[j] = min + graph.getMatrix()[k][j];
                    }

                }

                //打印当前步骤(非必须)
                for (int i = 0; i < shortTablePath.length; i++) {
                    System.out.print(shortTablePath[i] + "  ");
                }
                System.out.println();
                for (int i = 0; i < isGetPath.length; i++) {
                    System.out.print(isGetPath[i] + "  ");
                }
                System.out.println();
                System.out.println();
                System.out.println();
            }


            //打印到各个节点的最短路径
            for (int i = 0; i < shortTablePath.length; i++) {
                System.out.println("V0到V" + i + "最短路径为 " + shortTablePath[i]);
            }

        }

        //打印当期那的邻接矩阵
        public void printGraph(Graph graph) {
            for (int i = 0; i < graph.getVertexSize(); i++) {
                for (int j = 0; j < graph.getMatrix()[i].length; j++) {
                    if (graph.getMatrix()[i][j] < Graph.MAX_WEIGHT) {
                        System.out.print(graph.getMatrix()[i][j] + " ");
                    } else {
                        System.out.print("∞" + " ");
                    }
                }
                System.out.println();
            }
        }

    }


    public static class Edge {

        private int v1;
        private int v2;
        private int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public boolean equals(Edge edge) {
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
     * 贝尔曼福特算法 O(VE)
     */
    public static class Graph2 {

        private LinkedList<Edge>[] edgeLinks;
        private int vNum;    //顶点数
        private int edgeNum;    //边数
        private int[] distance;    //存放v.d
        private int[] prenode;    //存放前驱节点
        public static final int INF = 10000;    //无穷大
        public static final int NIL = -1;    //表示不存在

        public Graph2(int vnum) {
            this.vNum = vnum;
            edgeLinks = new LinkedList[vnum];
            edgeNum = 0;
            distance = new int[vnum];
            prenode = new int[vnum];
            for (int i = 0; i < vnum; i++)
                edgeLinks[i] = new LinkedList<>();
        }

        public void insertEdge(Edge edge) {
            int v1 = edge.getV1();
            edgeLinks[v1].add(edge);
            edgeNum++;
        }

        /**
         * 遍历打印出整个图信息
         */
        public void bianli() {
            System.out.println("共有 " + vNum + " 个顶点， " + edgeNum + " 条边");
            for (int i = 0; i < vNum; i++) {
                LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
                while (!list.isEmpty()) {
                    Edge edge = list.pop();
                    System.out.println(edge.toString());
                }
            }
        }

        /**
         * 对最短路径估计和前驱节点进行初始化
         *
         * @param start
         */
        public void initiate(int start) {
            for (int i = 0; i < vNum; i++) {
                distance[i] = INF;
                prenode[i] = NIL;
            }
            distance[start] = 0;
        }

        /**
         * 松弛
         *
         * @param edge
         */
        public void relax(Edge edge) {
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            int w = edge.getWeight();
            if (distance[v2] > distance[v1] + w) {
                distance[v2] = distance[v1] + w;
                prenode[v2] = v1;
            }
        }

        /**
         * Bellman-Ford算法实现
         *
         * @return 是否没有负环
         */
        public boolean bellmanFord(int start) {

            initiate(start);
            //对每条边进行V-1次松弛操作 因为找源点到剩下的V-1个点的路径
            for (int i = 0; i < vNum - 1; i++) {
                for (int j = 0; j < vNum; j++) {
                    LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[j].clone();
                    while (!list.isEmpty()) {
                        Edge edge = list.pop();
                        relax(edge);
                    }
                }
            }
            //检测是否存在环
            for (int i = 0; i < vNum; i++) {
                LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
                while (!list.isEmpty()) {
                    Edge edge = list.pop();
                    int v1 = edge.getV1();
                    int v2 = edge.getV2();
                    int w = edge.getWeight();
                    if (distance[v2] > distance[v1] + w)
                        return false;
                }
            }

            return true;
        }

        /**
         * 显示结果 利用堆栈
         */
        public void showResult() {
            Stack<Integer>[] routes = new Stack[vNum];
            for (int i = 0; i < vNum; i++) {
                routes[i] = new Stack<>();
                int j = i;
                while (j != NIL) {
                    routes[i].push(j);
                    j = prenode[j];
                }

                System.out.print(i + "(" + distance[i] + ") : ");
                while (!routes[i].isEmpty()) {
                    int k = routes[i].pop();
                    System.out.print("-->" + k);
                }
                System.out.println();
            }
        }


        public int[] getDistance() {
            return distance;
        }

        public int[] getPrenode() {
            return prenode;
        }

    }

    /**
     * 调用贝尔曼福特算法
     */
    public static void callBellmanFord() {
        int vnum = 5;
        Graph2 graph = new Graph2(vnum);
        Edge[] edges = new Edge[10];
        edges[0] = new Edge(0, 1, 6);
        edges[1] = new Edge(0, 3, 7);
        edges[2] = new Edge(1, 2, 5);
        edges[3] = new Edge(1, 3, 8);
        edges[4] = new Edge(1, 4, -4);
        edges[5] = new Edge(2, 1, -2);
        edges[6] = new Edge(3, 2, -3);
        edges[7] = new Edge(3, 4, 9);
        edges[8] = new Edge(4, 0, 2);
        edges[9] = new Edge(4, 2, 7);
        for (int i = 0; i < 10; i++) {
            graph.insertEdge(edges[i]);
        }
        graph.bianli();

        boolean success = graph.bellmanFord(0);
        if (success) {
            System.out.println("没有负环");
            graph.showResult();
        } else {
            System.out.println("存在负环");
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(Dijkstra.MAXVEX);
        graph.createGraph();
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.printGraph(graph);
        dijkstra.shortestPathDijkstra(graph);
    }
}
