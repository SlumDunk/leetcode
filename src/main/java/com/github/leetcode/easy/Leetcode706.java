package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/1/18 20:32
 * @Description: Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * <p>
 * Example:
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 * <p>
 * Note:
 * <p>
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class Leetcode706 {
    class MyHashMap {
        /**
         * 注意key的取值范围
         */
        int[] keyData = new int[1000001];
        /**
         * 注意value的取值范围
         */
        int[] valueData = new int[1000001];

        /**
         * 创建map
         */
        public MyHashMap() {

        }

        /**
         * 存入key和value值
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            //设置value数组中某个key的索引的值为value
            valueData[key] = value;
            //设置Key数组中对应的key为1,表示该key已经被占有了
            keyData[key] = 1;
        }

        /**
         * 如果存在这样的key，那么从值数组中返回该key对应的value
         *
         * @param key
         * @return
         */
        public int get(int key) {
            if (keyData[key] == 1) {
                return valueData[key];
            } else {
                return -1;
            }
        }

        /**
         * 从key数组中移除key值和从value数组中移除key对应的value
         *
         * @param key
         */
        public void remove(int key) {
            valueData[key] = 0;
            keyData[key] = 0;
        }
    }
}



