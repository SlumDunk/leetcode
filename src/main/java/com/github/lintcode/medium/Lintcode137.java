package com.github.lintcode.medium;

import com.github.leetcode.vo.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 10:08
 * @Description: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * How we serialize an undirected graph:
 * <p>
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * <p>
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <p>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 * Example
 * return a deep copied graph.
 */
public class Lintcode137 {
    /*
    * @param node: A undirected graph node
    * @return: A undirected graph node
    */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        //克隆点
        List<UndirectedGraphNode> nodeList = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        nodeList.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodeList.size()) {
            UndirectedGraphNode currentNode = nodeList.get(start);
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    nodeList.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
            start++;
        }
        //克隆边
        for (int i = 0; i < nodeList.size(); i++) {
            UndirectedGraphNode currentNode = nodeList.get(i);
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
