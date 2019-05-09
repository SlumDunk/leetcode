package com.github.lintcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 16:01
 * @Description: 长度为k的子串，没有重复字符
 */
public class Lintcode1377 {
    public int findSubstring(String str, int k) {
        int len = str.length();
        int upperBound = len - k;
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i <= upperBound; i++) {
            String subStr = str.substring(i, k + i);
            if (check(subStr)) {
                resultSet.add(subStr);
            }
        }

        return resultSet.size();
    }

    /**
     * 检查子串中是否有重复的字符
     *
     * @param subStr
     * @return
     */
    private boolean check(String subStr) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);
        for (char character :
                subStr.toCharArray()) {
            if (cnt[character - 'a'] == 1) {
                return false;
            }
        }
        return true;
    }
}
