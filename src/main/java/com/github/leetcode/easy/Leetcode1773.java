package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * <p>
 * The ith item is said to match the rule if one of the following is true:
 * <p>
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 * Example 2:
 * <p>
 * Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * Output: 2
 * Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= items.length <= 104
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey is equal to either "type", "color", or "name".
 * All strings consist only of lowercase letters.
 */
public class Leetcode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> keyToIndex = new HashMap<>();
        keyToIndex.put("type", 0);
        keyToIndex.put("color", 1);
        keyToIndex.put("name", 2);
        int index = keyToIndex.get(ruleKey);
        int ans = 0;
        for (List<String> item :
                items) {
            if (item.get(index).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
