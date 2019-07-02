package com.github.leetcode.medium;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 22:22
 * @Description: You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 * <p>
 * Input: "AAABBC"
 * Output: 188
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class Leetcode1079 {
    int count;

    public int numTilePossibilities(String tiles) {
        char[] cc = tiles.toCharArray();
        dfs(cc);
        return count;
    }

    /**
     * @param cc
     */
    void dfs(char[] cc) {
        HashSet<Character> visited = new HashSet<>();
        for (int i = 0; i < cc.length; i++) {
            //这一轮还没重复
            if (cc[i] >= 'A' && cc[i] <= 'Z' && !visited.contains(cc[i])) {
                visited.add(cc[i]);
                char temp = cc[i];
                //设置成访问过
                cc[i] = 'a';
                count++;
                dfs(cc);
                //重置
                cc[i] = temp;
            }
        }
    }
}
