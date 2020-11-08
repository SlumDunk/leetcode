package com.github.leetcode.medium;

import com.github.leetcode.vo.UndirectedGraphNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 21:11
 * @Description: Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization (so you can understand error output):
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * <p>
 * <p>
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * <p>
 * <p>
 * Visually, the graph looks like the following:
 * <p>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 * Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.
 */
public class Leetcode133 {
    /**
     * 旧节点和克隆节点的map集合
     */
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        } else {
            //map中是否已经有了新节点
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                //创建新节点
                UndirectedGraphNode head = new UndirectedGraphNode(node.label);
                //放入map
                map.put(node, head);
                //创建邻居节点并绑定关系
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    head.neighbors.add(cloneGraph(neighbor));
                }
                return head;
            }

        }
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    ;

    /**
     * O(V+E)
     * 每个节点访问一次，每条边访问一次， map.get()是O(1)忽略不计
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        //generate the edges and vertexs

        // clone nodes
        Map<Integer, Node> map = new HashMap<>();
        Node root = cloneNodes(node, map);

        return root;

    }

    private Node cloneNodes(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        if (!map.containsKey(node.val)) {
            map.put(node.val, new Node(node.val, new ArrayList<>()));
        }
        if (node.neighbors != null && node.neighbors.size() > 0) {
            for (Node neighbor : node.neighbors) {
                map.get(node.val).neighbors.add(cloneNodes(neighbor, map));
            }
        }
        return map.get(node.val);
    }

    /**
     * BFS O(V+E)
     *
     * @param node
     * @return
     */
    private Node clone2(Node node) {
        if (node == null) {
            return null;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            Map<Integer, Node> map = new HashMap<>();
            map.put(node.val, new Node(node.val, new ArrayList<>()));
            int root = node.val;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.neighbors != null && cur.neighbors.size() > 0) {
                    for (Node neighbor : cur.neighbors) {
                        if (!map.containsKey(neighbor.val)) {
                            map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                            queue.add(neighbor);
                        }
                        map.get(cur.val).neighbors.add(map.get(neighbor.val));
                    }
                }
            }

            return map.get(root);
        }
    }


    private Node clone3(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        //clone nodes
        helper(node, map, edgeMap);
        //clone edge
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Node copy = entry.getValue();

            if (edgeMap.get(key) != null && edgeMap.get(key).size() > 0) {
                for (Integer neighbor : edgeMap.get(key)) {
                    copy.neighbors.add(map.get(neighbor));
                }
            }
        }
        return map.get(node.val);
    }

    private void helper(Node node, Map<Integer, Node> map, Map<Integer, List<Integer>> edgeMap) {
        if (node == null) {
            return;
        } else {
            if (!map.containsKey(node.val)) {
                map.put(node.val, new Node(node.val, new ArrayList<>()));
            } else {
                return;
            }

            if (!edgeMap.containsKey(node.val)) {
                edgeMap.put(node.val, new ArrayList<>());
            }


            if (node.neighbors != null && node.neighbors.size() > 0) {
                for (Node neighbor : node.neighbors) {
                    edgeMap.get(node.val).add(neighbor.val);
                    helper(neighbor, map, edgeMap);
                }
            }
        }
    }

}
