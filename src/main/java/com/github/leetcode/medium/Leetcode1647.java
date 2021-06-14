package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * <p>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 * <p>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class Leetcode1647 {
    public int minDeletions(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        // 现存坑位
        TreeSet<Integer> treeSet = new TreeSet<>();
        int n = s.length();
        for (int i = 0; i <= n; i++) {
            treeSet.add(i);
        }
        int count = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count++;
            } else {
                if (treeSet.contains(count)) { // 坑位还在
                    treeSet.remove(count);
                } else {// 坑位不在了， 找最近的坑位
                    Integer bulk = treeSet.lower(count);
                    ans += (count - bulk);
                    if (bulk != 0) {
                        treeSet.remove(bulk);
                    }
                }
                count = 1;
            }
        }
        // 最后一种字符的处理
        if (treeSet.contains(count)) { // 坑位还在
            treeSet.remove(count);
        } else {// 坑位不在了， 找最近的坑位
            Integer bulk = treeSet.lower(count);
            ans += (count - bulk);
            if (bulk != 0) {
                treeSet.remove(bulk);
            }
        }
        return ans;
    }
}
