package com.github.leetcode.easy;

import java.util.*;

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
        //遍历字符串，将两边都只出现一次的子串放进map中，再做对比
        String[] arrayA = A.split(" ");
        String[] arrayB = B.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        //结果集合
        List<String> resultList = new ArrayList<String>();
        for (int i = 0; i < arrayA.length; i++) {
            if (map.containsKey(arrayA[i])) {
                resultList.remove(arrayA[i]);
            } else {
                map.put(arrayA[i], 1);
                resultList.add(arrayA[i]);
            }
        }
        for (int i = 0; i < arrayB.length; i++) {
            if (map.containsKey(arrayB[i])) {//B中出现两次
                resultList.remove(arrayB[i]);
            } else {
                map.put(arrayB[i], 1);
                //是否在A中出现过
                if (resultList.contains(arrayB[i])) {
                    resultList.remove(arrayB[i]);
                } else {//A中未出现，目前在B中出现一次
                    resultList.add(arrayB[i]);
                }
            }
        }
        String[] result = new String[resultList.size()];
        resultList.toArray(result);
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
