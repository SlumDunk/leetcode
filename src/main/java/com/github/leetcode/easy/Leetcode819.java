package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class Leetcode819 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

    }

    private static String symbolString = "!?',;.";

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        List<String> bannedList = new ArrayList<String>();
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>(4096);
        int mostCommon = 0;
        String mostCommonWord = null;
        //构造禁止的字符串数组list
        for (int i = 0; i < banned.length; i++) {
            bannedList.add(banned[i].toLowerCase());
        }
        //通过标点符号切割字符串
        String[] array = paragraph.split("[\\p{Punct}\\s]+");
        String tempString;
        for (int i = 0; i < array.length; i++) {
            tempString = array[i];
            //是否以特殊符号结尾
            if (!Character.isLetter(tempString.charAt(tempString.length() - 1))) {
                tempString = tempString.substring(0, tempString.length() - 1);
            }
            //不是禁止字符串
            if (bannedList.indexOf(tempString) == -1) {
                Integer value = null;
                value = wordCountMap.getOrDefault(tempString, 0) + 1;
                wordCountMap.put(tempString, value);
                if (mostCommon < value) {
                    mostCommon = value;
                    mostCommonWord = tempString;
                }
            }
        }
        return mostCommonWord;
    }
}
