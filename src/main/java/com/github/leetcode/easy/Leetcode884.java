package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 17:09
 * @Description: We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class Leetcode884 {
    public static void main(String[] args) {
        String A = "apple apple";
        String B = "banana";
        Leetcode884 leetcode884 = new Leetcode884();
        System.out.println(leetcode884.uncommonFromSentences(A, B));
    }

    public String[] uncommonFromSentences(String A, String B) {
        List<String> aList = new ArrayList<String>();
        List<String> bList = new ArrayList<String>();

        String[] arrayA = A.split(" ");
        String[] arrayB = B.split(" ");

        for (String item : arrayA
                ) {
            aList.add(item);
        }
        for (String item : arrayB
                ) {
            bList.add(item);
        }
        Set<String> uniqueSet = new HashSet<String>();
        List<String> resultList = new ArrayList<String>();
        generateUniqueList(bList, aList, uniqueSet, resultList);

        generateUniqueList(aList, bList, uniqueSet, resultList);
        String[] result = new String[resultList.size()];
        int index = 0;
        for (String item :
                resultList) {
            result[index] = item;
            index++;
        }
        return result;
    }

    private void generateUniqueList(List<String> aList, List<String> bList, Set<String> uniqueSet, List<String> resultList) {
        for (String item :
                bList) {
            if (uniqueSet.contains(item) || aList.contains(item)) {
                resultList.remove(item);
            } else {
                resultList.add(item);
                uniqueSet.add(item);
            }
        }
    }
}
