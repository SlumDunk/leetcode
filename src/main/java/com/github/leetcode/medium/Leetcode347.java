package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //step2—桶排序
        List<Integer>[] bucket = new List[nums.length + 1];//定义足够数量的桶
        for (int key : map.keySet())//按“键”遍历
        {
            int count = map.get(key);//获取数值为key的元素出现的频次
            //把出现频次相同的元素“扔”到序号等于频次的桶中
            if (bucket[count] == null)
                bucket[count] = new ArrayList<Integer>();
            bucket[count].add(key);
        }
        //step3—“逆序”取数据
        List<Integer> result = new ArrayList<Integer>();
        for (int i = nums.length; i > 0; i--)//注意i的起始值，当数组只有一个数据时
        {
            if (bucket[i] != null && result.size() < k)
                result.addAll(bucket[i]);
        }
        return result;
    }

}
