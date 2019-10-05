package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 10:24
 * @Description:
 */
public class Leetcode1146 {

    class SnapshotArray {
        List<HashMap<Integer, Integer>> snapshot = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        public SnapshotArray(int length) {

        }

        public void set(int index, int val) {
            map.put(index, val);
        }

        public int snap() {
            snapshot.add(new HashMap<>(map));
            return snapshot.size() - 1;
        }

        public int get(int index, int snap_id) {
            return snapshot.get(snap_id).getOrDefault(index, 0);
        }
    }

}
