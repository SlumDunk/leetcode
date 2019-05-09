package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 22:36
 * @Description:
 */
public class Flight {
    public List<List<Integer>> findPairs(int maximumOperatingTravelDistance, List<List<Integer>> forwardShippingRouteList, List<List<Integer>> returnShippingRouteList) {
        List<List<Integer>> result = new ArrayList<>();
        if (maximumOperatingTravelDistance <= 0 || forwardShippingRouteList == null || forwardShippingRouteList.size() == 0 || returnShippingRouteList == null || returnShippingRouteList.size() == 0) {
            return result;
        } else {
            //先对list进行排序,从小到大排序
            Collections.sort(forwardShippingRouteList, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return Integer.compare(o1.get(1), o2.get(1));
                }
            });
            Collections.sort(returnShippingRouteList, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return Integer.compare(o1.get(1), o2.get(1));
                }
            });
            int left = 0, right = returnShippingRouteList.size() - 1;
            List<Integer> pair = new ArrayList<>();
            int nearest = 0;
            while (left < forwardShippingRouteList.size() && right >= 0) {
                int forwardDistance = forwardShippingRouteList.get(left).get(1);
                int rightDistance = returnShippingRouteList.get(right).get(1);
                int distance = forwardDistance + rightDistance;
                if (distance == maximumOperatingTravelDistance) {
                    pair.add(forwardShippingRouteList.get(left).get(0));
                    pair.add(returnShippingRouteList.get(right).get(0));
                    result.add(new ArrayList<>(pair));
                    pair.clear();
                    right--;
                } else if (distance < maximumOperatingTravelDistance && distance > nearest) {
                    result.clear();
                    pair.add(forwardShippingRouteList.get(left).get(0));
                    pair.add(returnShippingRouteList.get(right).get(0));
                    result.add(new ArrayList<>(pair));
                    pair.clear();
                    left++;
                } else if (distance < maximumOperatingTravelDistance) {
                    left++;
                } else {
                    right--;
                }
            }
            return result;
        }
    }
}
