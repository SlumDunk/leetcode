package com.github.graph;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/5/19 09:38
 * @Description:强连通分量 有向图 O(V+E)
 */
public class StrongConnectedComponents {

    public static int MAX = 100;
    public static int count;   //用于对图中顶点遍历的次序进行计数
    public static int n;
    public static int[] DFN = new int[MAX];    //记录图中每个节点的DFS遍历的时间戳(即次序)
    public static int[] Low = new int[MAX];   //记录每个顶点的所属的连通分量
    public static boolean[] inStack = new boolean[MAX];  //用于记录当前节点是否在栈中
    /**
     * 用于存储深度优先搜索过程中未处理过的节点
     */
    public static Stack<Integer> stack;
    /**
     * 标志节点是否已经访问过 每次找到强连通分量后更新
     */
    public static boolean[] visited;

    public void init(int n) {
        count = 0;
        stack = new Stack<Integer>();
        for (int i = 0; i <= n; i++) {
            DFN[i] = -1;   //代表顶点i未被遍历
            Low[i] = -1;
            inStack[i] = false;
            visited[i] = false;
        }
    }

    /**
     * 定义边的类
     */
    static class edge {
        public int a;  //边的起点
        public int b;  //边的终点

        edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    /**
     * @param map   图的边集合
     * @param start 开始节点
     */
    public void dfs(ArrayList<edge>[] map, int start) {
        DFN[start] = count++;
        Low[start] = DFN[start];
        //先入栈，回溯用
        stack.push(start);
        inStack[start] = true;
        int j;
        for (int i = 0; i < map[start].size(); i++) {
            j = map[start].get(i).b;
            if (DFN[j] == -1) {  //顶点j未被遍历
                dfs(map, j);
                Low[start] = Math.min(Low[start], Low[j]);
            } else if (inStack[j]) {//找到闭环了
                //更新当前节点所属的连通分量
                Low[start] = Math.min(Low[start], DFN[j]);
            }
        }
        //由根部节点打印出强连通分量
        if (DFN[start] == Low[start]) {
            System.out.print("强连通分量：");
            do {
                j = stack.pop();
                System.out.print(j + " ");
                visited[j] = true;
                inStack[j] = false;
            } while (start != j);
            System.out.println();
        }
        return;
    }

    public static void main(String[] args) {
        StrongConnectedComponents graph = new StrongConnectedComponents();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        graph.init(n);
        int k = in.nextInt();  //有向图的边数目
        //边集合
        ArrayList<edge>[] map = new ArrayList[n + 1];
        //下标代表节点编号
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<edge>();
        in.nextLine();
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map[a].add(new edge(a, b));
        }
//        graph.dfs(map, 1);
        graph.findStrongConnectedComponents(map);
    }

    /**
     * 查找图中的所有强连通分量
     *
     * @param map
     */
    private void findStrongConnectedComponents(ArrayList<edge>[] map) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(map, i);
            }
        }
    }
}
