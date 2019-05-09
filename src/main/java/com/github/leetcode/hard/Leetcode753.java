package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 5/7/19 13:55
 * @Description: There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.
 * <p>
 * You can keep inputting the password, the password will automatically be matched against the last n digits entered.
 * <p>
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
 * <p>
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
 * <p>
 * Example 1:
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * Example 2:
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * Note:
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 */
public class Leetcode753 {
    public String crackSafe(int n, int k) {
        int size = (int) Math.pow(k, n);
        char[] password = new char[n];
        Arrays.fill(password, '0');
        StringBuilder res = new StringBuilder(String.valueOf(password));

        Set<String> visited = new HashSet<>();
        visited.add(res.toString());
        if (dfs(res, visited, n, k, size)) return res.toString();
        return "";
    }

    private boolean dfs(StringBuilder res, Set<String> visited, int n, int k, int size) {
        if (visited.size() == size) return true;

        String prefix = res.substring(res.length() - n + 1, res.length());
        for (char i = '0'; i < '0' + k; i++) {
            String password = prefix + i;
            if (!visited.contains(password)) {
                res.append(i);
                visited.add(password);
                if (dfs(res, visited, n, k, size)) return true;
                visited.remove(password);
                res.deleteCharAt(res.length() - 1);
            }
        }
        return false;
    }
}
