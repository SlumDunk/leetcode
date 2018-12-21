package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * <p>
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class Leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //用两个map分别存储两个数组各个餐厅的位置
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        //存储两者共同喜欢的餐厅的索引，要求索引和最小，这里保存该餐厅在list1中的位置索引
        List<String> resultList = new ArrayList<String>();
        //
        int min = list1.length + list2.length;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (min > map1.get(key) + map2.get(key)) {//有更小的
                    resultList.clear();//清空集合
                    resultList.add(key);//添加新元素
                    min = map1.get(key) + map2.get(key);//更新最小值
                } else if (min == map1.get(key) + map2.get(key)) {//跟最小值相等的，直接添加
                    resultList.add(key);
                }
            }
        }

        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
