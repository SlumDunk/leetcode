package com.github.leetcode.easy;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:01
 * @Description:
 */
public class Leetcode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> arraysMap = new HashMap<>();

        for(int i = 0 ; i < arr.length; i++) {
            arraysMap.put(target[i], arraysMap.getOrDefault(target[i],0)+1);
            arraysMap.put(arr[i], arraysMap.getOrDefault(arr[i],0)-1);
        }

        for(Integer key : arraysMap.keySet()) {
            if(arraysMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
