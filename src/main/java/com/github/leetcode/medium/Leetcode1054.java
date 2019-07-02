package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 09:06
 * @Description: In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
 * <p>
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * Example 2:
 * <p>
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 */
public class Leetcode1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0) return barcodes;
        //key为数值，value为出现的次数
        Map<Integer, Integer> counter = new HashMap<>();
        //出现最多的次数
        int max_fre = 0;
        for (int num : barcodes) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.get(num) > max_fre) {
                max_fre = counter.get(num);
            }
        }
        //存储出现次数对应的数字
        List<Integer>[] buckets = new ArrayList[max_fre + 1];
        for (int num : counter.keySet()) {
            int c = counter.get(num);
            if (buckets[c] == null) {
                buckets[c] = new ArrayList<>();
            }
            buckets[c].add(num);
        }

        int index = 0;//先插奇数位，再插偶数位
        int[] res = new int[barcodes.length];
        for (int i = max_fre; i >= 1; i--) {
            List<Integer> b = buckets[i];
            if (b == null) continue;
            for (int num : b) {
                int j = i;
                while (j > 0) {//插空
                    res[index] = num;
                    index = index + 2 < barcodes.length ? index + 2 : 1;
                    j--;
                }
            }
        }
        return res;
    }
}
