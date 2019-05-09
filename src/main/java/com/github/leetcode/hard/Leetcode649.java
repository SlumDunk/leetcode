package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/21/19 20:39
 * @Description:
 */
public class Leetcode649 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < 0.001) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (double c :
                        generatePossibleResults(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i) continue;
                        nextRound.add(list.get(k));
                    }
                    if (dfs(nextRound)) return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取两个数可能的结果
     *
     * @param a
     * @param b
     * @return
     */
    private List<Double> generatePossibleResults(Double a, Double b) {
        List<Double> result = new ArrayList<>();
        result.add(a + b);
        result.add(a - b);
        result.add(b - a);
        result.add(a * b);
        result.add(a / b);
        result.add(b / a);
        return result;
    }

}
