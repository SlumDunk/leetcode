package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:41
 * @Description: There is a special keyboard with all keys in a single row.
 * <p>
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 * <p>
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4.
 * Example 2:
 * <p>
 * Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * Output: 73
 * <p>
 * <p>
 * Constraints:
 * <p>
 * keyboard.length == 26
 * keyboard contains each English lowercase letter exactly once in some order.
 * 1 <= word.length <= 10^4
 * word[i] is an English lowercase letter.
 */
public class Leetcode1165 {
    public int calculateTime(String keyboard, String word) {
        int startIndex = 0;
        int currentIndex;
        int result = 0;
        for (char c : word.toCharArray()) {
            currentIndex = keyboard.indexOf(c);
            result += Math.abs(currentIndex - startIndex);
            startIndex = currentIndex;
        }
        return result;
    }
}
