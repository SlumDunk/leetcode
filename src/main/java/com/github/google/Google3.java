package com.github.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/4/18 11:00
 * @Description: 给你一个array［］， 每一个element存的是它parents的位置。
 * 给你一个distance n, 是一个 int, 让你 return 一个array，表示每个element与它n距离的ancestor
 */
public class Google3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 0, 3, 4};
        int n = 2;
        int[] result = findAncestor(nums, n);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }

    private static int[] findAncestor(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            //create a map to save ancestor of each nodes
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> valueList;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != -1) {
                    map.put(i, nums[i]);
                } else {
                    map.put(i, -1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = findNAncestor(i, map, n);
            }
        }
        return nums;
    }

    private static int findNAncestor(int i, Map<Integer, Integer> map, int n) {
        while (map.get(i) != -1 && n > 0) {
            n--;
            i = map.get(i);
        }
        if (n > 0) {
            return -1;
        } else {
            return i;
        }
    }
}
