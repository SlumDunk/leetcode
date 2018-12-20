package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 13:51
 * @Description: Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Leetcode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //step1—用哈希表统计数组中各元素出现的频次，表中“键”为元素数值，“值”为对应元素出现的频次
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)//遍历数组
        {
            if (map.get(num) == null)//如果“键”为num的数据首次出现，则“值”设为1
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);//重复出现，则累计频次
        }
        //存储各个数字出现的次数
        int[] count = new int[map.keySet().size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            count[index] = map.get(key);
            index++;
        }
        //对数组进行排序
        Arrays.sort(count);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = count.length - 1; i >= 0; i--) {
            //查找当前key中value等于count[i]的数字，并添加到结果集中
            for (Integer key : map.keySet()) {
                if (count[i] == map.get(key)) {
                    result.add(key);
                    map.remove(key);
                    break;
                }
            }
            if (result.size() == k) {
                return result;
            }
        }
        return result;
    }

}
