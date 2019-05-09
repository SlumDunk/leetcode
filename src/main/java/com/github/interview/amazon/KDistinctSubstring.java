package com.github.interview.amazon;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 14:39
 * @Description: 拥有k 个distinct字符的子串个数
 */
public class KDistinctSubstring {
    public int countkDistinct(String str, int k) {
        int res = 0;
        int n = str.length();
        int cnt[] = new int[26];

        for (int i = 0; i < n; i++) {
            int dis_count = 0;
            Arrays.fill(cnt, 0);
            for (int j = i; j < n; j++) {
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    dis_count++;
                }

                cnt[str.charAt(j) - 'a']++;
                if (dis_count == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
