package com.github.leetcode.easy;

/**
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2:
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class Leetcode443 {
    public int compress(char[] chars) {
        //数组目前的长度，下一次开始的位置
        int len = chars.length, cur = 0;
        //双指针
        for (int left = 0, right = 0; left < len; left = right) {
            //注意数组长度边界问题 字符相同的连续子串
            while (right < len && chars[left] == chars[right]) right++;

            chars[cur] = chars[left];
            cur++;
            //只有一个连续的字符，不做处理
            if (right - left == 1) continue;
            //计算字符出现的次数
            String countStr = String.valueOf(right - left);
            //放入数组中
            for (int k = 0; k < countStr.length(); k++) {
                chars[cur] = countStr.charAt(k);
                cur++;
            }
        }
        return cur;
    }
}
