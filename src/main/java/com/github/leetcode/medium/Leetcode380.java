package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 21:07
 * @Description: Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
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
         * 存储元素的位置索引Map
         */
        Map<Integer, Integer> map;
        /**
         * 存储元素
         */
        List<Integer> list;
        int lastIndex;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new LinkedList<>();
            lastIndex = 0;
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
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
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            //维护索引位置，最后一个元素移到要删除元素的位置
            map.put(list.get(lastIndex - 1), map.get(val));
            //交换要删除的元素和末尾元素的位置
            swap(map.get(val), lastIndex - 1);
            //移除最后一个元素
            list.remove(lastIndex - 1);
            //将要移除的元素位置索引移除
            map.remove(val);
            //长度减1
            lastIndex--;

            return true;
        }

        /**
         * 交换元素
         */
        private void swap(int id1, int id2) {
            int temp = list.get(id1);
            list.set(id1, list.get(id2));
            list.set(id2, temp);
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random rand = new Random();
            //返回随机索引位置
            int idx = rand.nextInt(lastIndex);
            return list.get(idx);
        }
    }

}
