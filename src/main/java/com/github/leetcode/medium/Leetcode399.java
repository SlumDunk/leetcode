package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 12:27
 * @Description: Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class Leetcode399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        double[] result = new double[query.length];
        // 过滤掉没有遇见过的字符
        Set<String> words = new HashSet<>();
        for (String[] strs : equations) {
            words.add(strs[0]);
            words.add(strs[1]);
        }
        for (int i = 0; i < query.length; ++i) {
            String[] keys = query[i];
            if (!words.contains(keys[0]) || !words.contains(keys[1])) result[i] = -1.0d;
            else {
                List<Integer> temp = new ArrayList<Integer>();
                result[i] = helper(equations, values, keys, temp);
            }
        }
        return result;
    }

    /**
     * @param equations 除数和被除数关系集合
     * @param values    商集合
     * @param keys      目标除数和被除数对
     * @param list      存储路径上的节点
     * @return
     */
    public double helper(String[][] equations, double[] values, String[] keys, List<Integer> list) {
        // 直接查找，key的顺序有正反
        for (int i = 0; i < equations.length; ++i) {
            if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) return values[i];
            if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) return 1 / values[i];
        }
        // 间接查找，key的顺序也有正反
        for (int i = 0; i < equations.length; ++i) {
            //防止出现环路
            if (!list.contains(i) && keys[0].equals(equations[i][0])) {
                list.add(i);
                //(key[0]/equation[1])*(equation[1]/key[1])
                double temp = values[i] * helper(equations, values, new String[]{equations[i][1], keys[1]}, list);
                if (temp > 0) {
                    return temp;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            //防止出现环路
            if (!list.contains(i) && keys[0].equals(equations[i][1])) {
                list.add(i);
                // (equation[0]/k[1])/(equation[0]/key[0])
                double temp = helper(equations, values, new String[]{equations[i][0], keys[1]}, list) / values[i];
                if (temp > 0) {
                    return temp;
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
        // 查不到，返回-1
        return -1.0d;
    }
}
