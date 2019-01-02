package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 21:07
 * @Description: Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an val val to the set if not already present.
 * remove(val): Removes an val val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class Leetcode380 {
    class RandomizedSet {
        /**
         * 存储元素和元素在list中对应的位置索引
         */
        Map<Integer, Integer> map;
        /**
         * 存储元素
         */
        List<Integer> list;
        /**
         * 下一个元素的位置索引
         */
        int lastIndex;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new LinkedList<>();
            lastIndex = 0;
        }

        /**
         * 往集合中插入元素，如果已经存在该元素的话，存在返回false
         *
         * @param val
         * @return
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            map.put(val, lastIndex);
            lastIndex++;

            return true;
        }

        /**
         * 从集合中移除元素，如果存在的话，返回true,不存在，返回false
         *
         * @param val
         * @return
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            //维护元素的索引位置信息
            //把最后一个元素放到要删除元素的位置
            map.put(list.get(lastIndex - 1), map.get(val));
            //将要删除的元素交换到list的末尾
            swap(lastIndex - 1, map.get(val));
            //将该元素从map中移除
            map.remove(val);
            //将末尾元素移除
            list.remove(lastIndex - 1);
            //调整list长度
            lastIndex--;

            return true;
        }

        /**
         * 交换元素
         *
         * @param tail   末尾元素
         * @param target 要删除的元素
         */
        private void swap(int tail, int target) {
            int temp = list.get(tail);
            list.set(tail, list.get(target));
            list.set(target, temp);
        }

        /**
         * 获取一个随机元素
         *
         * @return
         */
        public int getRandom() {
            Random rand = new Random();
            //返回随机索引位置
            int idx = rand.nextInt(lastIndex);
            return list.get(idx);
        }
    }
}
