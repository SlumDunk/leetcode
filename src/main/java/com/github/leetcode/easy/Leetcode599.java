package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

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
        List<String> listA = new ArrayList<String>(list1.length);
        List<String> listB = new ArrayList<String>(list2.length);

        for (int i = 0; i < list1.length; i++) {
            listA.add(list1[i]);
        }

        for (int i = 0; i < list2.length; i++) {
            listB.add(list2[i]);
        }
        String temp = null;
        int index = -1;
        int minSum = Integer.MAX_VALUE;
        List<String> resultList = new ArrayList<String>();
        for (int i = 0; i < listA.size(); i++) {
            temp = listA.get(i);
            index = listB.indexOf(temp);
            if (index >= 0) {
                if (minSum != Integer.MAX_VALUE) {
                    if (minSum == i + index) {
                        resultList.add(temp);
                    } else if (minSum > i + index) {
                        resultList.clear();
                        resultList.add(temp);
                    }
                } else {
                    resultList.add(temp);
                }
                minSum = Math.min(minSum, i + index);
            }
        }
        String[] result = new String[resultList.size()];

        resultList.toArray(result);
        return result;
    }
}
