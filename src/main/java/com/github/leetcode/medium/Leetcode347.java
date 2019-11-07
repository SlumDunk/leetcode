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
    /**
     * hashtable
     *
     * @param nums
     * @param k
     * @return
     */
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

    /**
     * 堆排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequentHeap(int[] nums, int k) {
        //step1—用哈希表统计数组中各元素出现的频次，表中“键”为元素数值，“值”为对应元素出现的频次
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)//遍历数组
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //按出现频次从小到大排序
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> result = new LinkedList();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }

    /**
     * 桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequentBucket(int[] nums, int k) {
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


    class Pair {
        int val;
        int cnt;

        public Pair(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    Map<Integer, Pair> map = new HashMap<>();

    public List<Integer> topKFrequent_(int[] nums, int k) {
        // Arrays.sort(nums);
        for (int num : nums) {
            Pair pair = map.getOrDefault(num, new Pair(num, 0));
            pair.cnt++;
            map.put(num, pair);
        }

        Queue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.cnt, b.cnt);
            }
        });

        for (Integer key : map.keySet()) {
            pq.offer(map.get(key));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().val);
        }

        return result;
    }
}
