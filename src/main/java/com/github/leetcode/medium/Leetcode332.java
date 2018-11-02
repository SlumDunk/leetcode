package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 21:24
 * @Description: Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class Leetcode332 {
    HashMap<String, List<String>> maps;
    int count;

    public List<String> findItinerary(String[][] tickets) {
        maps = new HashMap<>();
        initHashMap(tickets);

        count = tickets.length + 1;
        List<String> res = new LinkedList<>();
        res.add("JFK");
        dfs(res);
        return res;
    }

    private boolean dfs(List<String> res) {
        if (res.size() == count)
            return true;
        String top = res.get(res.size() - 1);
        List<String> lists = maps.get(top);
        if (lists == null)
            return false;

        for (int i = 0; i < lists.size(); i++) {
            String tmp = lists.get(i);
            res.add(tmp);
            lists.remove(i);

            if (dfs(res))//当找到合适点之后，直接返回true
                return true;
            lists.add(i, tmp);//恢复现场
            res.remove(res.size() - 1);
        }
        return false;
    }

    private void initHashMap(String[][] tickets) {
        for (String[] tmp : tickets) {
            String from = tmp[0];
            String to = tmp[1];

            if (!maps.containsKey(from)) {
                maps.put(from, new LinkedList<>());
            }
            List<String> list = maps.get(from);

            int index = 0;
            int size = list.size();
            while (index < size) {
                String cur = list.get(index);
                if (cur.compareTo(to) >= 0) {
                    break;
                }
                index++;
            }
            list.add(index, to);
        }
    }
}
