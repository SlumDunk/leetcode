package com.github.leetcode.medium;

import com.github.leetcode.vo.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

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
}
