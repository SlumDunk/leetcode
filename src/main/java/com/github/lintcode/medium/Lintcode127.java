package com.github.lintcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 10:32
 * @Description:
 */
public class Lintcode127 {
    /*
    * @param graph: A list of Directed graph node
    * @return: Any topological order for the given graph.
    */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return null;
        } else {
            ArrayList<DirectedGraphNode> resultList = new ArrayList<DirectedGraphNode>();
            //各节点的入度
            Map<DirectedGraphNode, Integer> degree = new HashMap<>();
            for (DirectedGraphNode node : graph) {
                for (DirectedGraphNode neighbor : node.neighbors) {
                    degree.put(neighbor, degree.getOrDefault(neighbor, 0) + 1);
                }
            }

            Queue<DirectedGraphNode> queue = new LinkedList<>();
            for (DirectedGraphNode node : graph) {
                if (!degree.containsKey(node)) {
                    queue.offer(node);
                }
            }

            while (!queue.isEmpty()) {
                DirectedGraphNode currentNode = queue.poll();
                resultList.add(currentNode);
                for (DirectedGraphNode neighbor : currentNode.neighbors) {
                    degree.put(neighbor, degree.get(neighbor) - 1);
                    if (degree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            return resultList;
        }
    }

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
