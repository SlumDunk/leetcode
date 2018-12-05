package com.github.google;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 12/4/18 10:29
 * @Description: 给出两个数组，stores和houses，表示每个store和house的位置，要求找出每个house最近的store，如果离左右两个store距离相同，输出左边一个。
 * 这里houses和stores都是无序的，每个位置可以有多个stores和houses
 * stores: [3, 5];
 * houses: [6, 2, 4];
 * output: [5, 3, 3];
 */
public class Google2 {
    public static void main(String[] args) {
        int[] stores = {3, 5};
        int[] houses = {6, 2, 4};
        int[] result = findNearestStores(stores, houses);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] findNearestStores(int[] stores, int[] houses) {
        if (stores == null || stores.length == 0 || houses == null || houses.length == 0) {
            return null;
        }
        TreeSet<Integer> storeSet = new TreeSet<>();
        for (int store : stores
                ) {
            storeSet.add(store);
        }
        Integer lower;
        Integer higher;
        for (int i = 0; i < houses.length; i++) {
            lower = storeSet.floor(houses[i]);
            higher = storeSet.ceiling(houses[i]);
            if (lower == null) {
                houses[i] = higher;
            } else if (higher == null) {
                houses[i] = lower;
            } else if (houses[i] - lower <= higher - houses[i]) {
                houses[i] = lower;
            } else {
                houses[i] = higher;
            }
        }
        return houses;
    }
}
