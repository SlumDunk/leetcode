package com.github.graph;

import java.util.*;

public class HeapSolutionBipartite {

    static class GraphNode {
        int value;
        char color;
        List<GraphNode> neighbors;

        public GraphNode() {

        }

        public GraphNode(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }
    }

    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }


    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLayer = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(curLayer);
        }
        return list;


    }

    public boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;

    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);

        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            // the group assigned for cur node;
            int curGroup = visited.get(cur);
            // the group assigned for any neighbor of cur node
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<GraphNode> graph = new ArrayList<>();
        //左边 u
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        //右边 v
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);
        GraphNode node9 = new GraphNode(9);

        node1.neighbors.add(node6);

        node2.neighbors.add(node6);
        node2.neighbors.add(node7);

        node3.neighbors.add(node7);
        node3.neighbors.add(node8);

        node4.neighbors.add(node7);

        node5.neighbors.add(node6);

        node5.neighbors.add(node9);

        HeapSolutionBipartite solution = new HeapSolutionBipartite();
        System.out.println(solution.isBipartite(graph));


    }
}

