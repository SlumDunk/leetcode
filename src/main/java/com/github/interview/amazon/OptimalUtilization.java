package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 09:11
 * @Description:
 */
public class OptimalUtilization {
    public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = forwardRouteList.length, len2 = returnRouteList.length;
        if (len1 == 0 || len2 == 0) return res;
        Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        int left = 0, right = len2 - 1, maxVal = -1;
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        while (left < len1 && right >= 0) {
            int sum = forwardRouteList[left][1] + returnRouteList[right][1];
            if (sum > maxTravelDist) {
                --right;
                continue;
            }
            if (sum >= maxVal) {
                int r = right;
                map.putIfAbsent(sum, new ArrayList<>());
                // check the duplicates
                while (r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(forwardRouteList[left][0]);
                    list.add(returnRouteList[r][0]);
                    map.get(sum).add(list);
                    --r;
                }
                maxVal = sum;
            }
            ++left;
        }
        return map.get(maxVal);
    }
}
