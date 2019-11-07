package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 10:36
 * @Description: Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        int len = strs.length;
        if (len < 1) return list;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        String tmp = "";
        for (int i = 0; i < len; i++) {
            tmp = strs[i];
            //字符串转化为字符数组
            char[] arrayOfString = tmp.toCharArray();
            //对字符数组排序
            Arrays.sort(arrayOfString);
            tmp = new String(arrayOfString);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            } else {
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(tmp, item);
            }
        }
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }


    /**
     * O(n*mlgm)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams__(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        } else {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = reorder(str);
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    map.put(key, new ArrayList<>());
                    map.get(key).add(str);
                }

            }

            for (List<String> value : map.values()) {
                result.add(value);
            }

            return result;
        }
    }

    private String reorder(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
