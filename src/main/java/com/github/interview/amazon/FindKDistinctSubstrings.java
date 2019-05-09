package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 4/11/19 13:09
 * @Description: 长度为k的子串，字符不能重复
 */
public class FindKDistinctSubstrings {
    public List<String> findKDistinctSubStrings(String str, int k) {
        int len = str.length();
        int l = 0, startIndex = 0;
        Set<Character> set = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        while (l <= len - k) {
            for (int i = 0; i < k; i++) {
                set.add(str.charAt(l));
                l++;
            }
            if (set.size() == k) {
                resultSet.add(str.substring(l, l + k));
            }
            set.clear();
            startIndex++;
            l = startIndex;
        }
        List<String> resultList = new ArrayList<>();
        for (String substr :
                resultSet) {
            resultList.add(substr);
        }
        return resultList;
    }
}
