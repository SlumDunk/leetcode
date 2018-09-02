package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/1/18 19:55
 * @Description: Design a HashSet without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 * <p>
 * Example:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class Leetcode705 {
    class MyHashSet {
        int[] data = new int[1000001];

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
        }

        public void add(int key) {
            if (data[key] == 0) {
                data[key]++;
            }
        }

        public void remove(int key) {
            if (data[key] > 0) {
                data[key]--;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            if (data[key] > 0) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }
    }

}
