package com.github.leetcode.medium;

import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 19:58
 * @Description: Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 * <p>
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class Leetcode870 {
    /**
     * 田忌赛马
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            Integer key = map.higherKey(B[i]);
            if (key == null) ans[i] = -1;//没有大于当前元素的值，打标志，待分配
            else {
                ans[i] = key;
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
            }
        }
        //给未分配值的空位分配
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) {
                int firstKey = map.firstKey();
                ans[i] = firstKey;
                map.put(firstKey, map.get(firstKey) - 1);
                if (map.get(firstKey) == 0) map.remove(firstKey);
            }
        }
        return ans;
    }
}
