package com.github.leetcode.easy;

import java.util.*;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Leetcode697 {

    public static void main(String[] args) {
        Leetcode697 leetcode697 = new Leetcode697();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(leetcode697.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> dataMap = new HashMap<Integer, Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (dataMap.get(nums[i]) == null) {
                dataMap.put(nums[i], 1);
            } else {
                dataMap.put(nums[i], dataMap.get(nums[i]) + 1);
            }
            numList.add(nums[i]);
        }
        dataMap = sortByComparator(dataMap);
        Integer degree = Integer.MIN_VALUE;
        List<Integer> degreeList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()
                ) {
            degree = Math.max(degree, entry.getValue());
            if (entry.getValue().equals(degree)) {
                degreeList.add(entry.getKey());
            } else {
                break;
            }
        }
        int min = nums.length;
        for (int i = 0; i < degreeList.size(); i++) {
            min = Math.min(min, numList.lastIndexOf(degreeList.get(i)) - numList.indexOf(degreeList.get(i)) + 1);
        }
        return min;
    }

    public static Map sortByComparator(Map unsortMap) {
        List list = new LinkedList(unsortMap.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map sortedMap = new LinkedHashMap();

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}
