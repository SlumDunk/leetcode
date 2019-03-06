package com.github.leetcode.hard;

import com.github.leetcode.vo.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 21:49
 * @Description: Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class Leetcode352 {
    class SummaryRanges {

        TreeMap<Integer, Interval> treeMap;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            if (treeMap.containsKey(val)) return;
            Integer lowerKey = treeMap.lowerKey(val);
            Integer higherKey = treeMap.higherKey(val);
            //[1,2] 3 [4,5] -> [1,5] 连接左右两个区间
            if (lowerKey != null && higherKey != null && treeMap.get(lowerKey).end + 1 == val && val + 1 == treeMap.get(higherKey).start) {
                treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
                treeMap.remove(higherKey);
            } else if (lowerKey != null && val <= treeMap.get(lowerKey).end + 1) {//[1,4] 2 合并到左区间
                treeMap.get(lowerKey).end = Math.max(treeMap.get(lowerKey).end, val);
            } else if (higherKey != null && treeMap.get(higherKey).start - 1 == val) {//[3,5] -> [2,5] 合并到右区间
                treeMap.put(val, new Interval(val, treeMap.get(higherKey).end));
                treeMap.remove(higherKey);
            } else {//独立一个区间
                treeMap.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(treeMap.values());
        }
    }

}
