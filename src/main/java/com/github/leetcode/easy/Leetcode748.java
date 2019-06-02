package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 11:04
 * @Description: Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * <p>
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class Leetcode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] origArray = createCountArray(licensePlate);
        String candidate = null;
        for (String word : words) {
            if (contains(origArray, createCountArray(word))) {
                candidate = (candidate == null || candidate.length() > word.length()) ? word : candidate;
            }
        }
        return candidate;
    }

    /**
     * 创建单词字符数组
     *
     * @param word
     * @return
     */
    private int[] createCountArray(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                arr[Character.toLowerCase(c) - 'a']++;
            }
        }
        return arr;
    }

    /**
     * @param plate 车牌字符数组
     * @param word  单词字符数组
     * @return
     */
    private boolean contains(int[] plate, int[] word) {
        for (int i = 0; i < plate.length; i++) {
            if (plate[i] != 0 && plate[i] > word[i]) {
                return false;
            }
        }
        return true;
    }
}

