package com.github.interview.amazon;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 12/19/19 00:34
 * @Description:
 */
public class CriticalConnection_2 {
    class PairInt {
        int first;
        int second;

        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * result list
     */
    List<PairInt> list;
    /**
     * visited map
     */
    Map<Integer, Boolean> visited;

    /**
     * O(E*E*V)
     *
     * @param numOfServers
     * @param numOfConnections
     * @param connections
     * @return
     */
    List<PairInt> criticalConnections(int numOfServers, int numOfConnections,
                                      List<PairInt> connections) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (PairInt connection : connections) {
            int u = connection.first;
            int v = connection.second;
            if (adj.get(u) == null) {
                adj.put(u, new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if (adj.get(v) == null) {
                adj.put(v, new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for (int i = 0; i < numOfConnections; i++) {
            visited = new HashMap<>();

            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            //remove current edge
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            //start from server 1
            helper(adj, 1);
            //if all servers could not be visited after removing this edge, it means this is the critical edge
            if (visited.size() != numOfServers) {
                if (p.first > p.second)
                    list.add(new PairInt(p.second, p.first));
                else
                    list.add(p);
            }
            //backtrack to repair such edge
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }

    /**
     * @param adj graph
     * @param u   start node
     */
    public void helper(Map<Integer, HashSet<Integer>> adj, int u) {
        visited.put(u, true);
        if (adj.get(u).size() != 0) {
            for (int v : adj.get(u)) {
                if (visited.getOrDefault(v, false) == false) {
                    helper(adj, v);
                }
            }
        }
    }
}
