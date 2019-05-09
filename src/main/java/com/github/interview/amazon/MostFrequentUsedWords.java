package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 4/9/19 23:00
 * @Description:
 */
public class MostFrequentUsedWords {
    public String[] mostFrequentUsedWords(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return new String[]{};
        }
        paragraph = paragraph.toLowerCase();
        List<String> bannedList = new ArrayList<>();
        Map<String, Integer> wordCountMap = new HashMap<>();
        int mostFrequent = 0;
        List<String> mostFrequentList = new ArrayList<>();
        for (String banString :
                banned) {
            bannedList.add(banString);
        }
        String[] array = paragraph.split("[\\p{Punct}\\s]+");
        String tempString;
        for (int i = 0; i < array.length; i++) {
            tempString = array[i];
            if (!Character.isLetter(tempString.charAt(tempString.length() - 1))) {
                tempString = tempString.substring(0, tempString.length() - 1);
            }
            if (bannedList.indexOf(tempString) != -1) {
                Integer value = wordCountMap.getOrDefault(tempString, 0) + 1;
                wordCountMap.put(tempString, value);
                if (mostFrequent < value) {
                    mostFrequentList.clear();
                    mostFrequentList.add(tempString);
                } else if (mostFrequent == value) {
                    mostFrequentList.add(tempString);
                }
            }

        }
        String[] result = new String[mostFrequentList.size()];
        int i = 0;
        for (String word :
                mostFrequentList) {
            result[i] = word;
            i++;
        }
        return result;
    }
}
