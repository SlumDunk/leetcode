package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class Leetcode821 {
    public static void main(String[] args) {
        Leetcode821 leetcode821 = new Leetcode821();
        System.out.println(leetcode821.shortestToChar("loveleetcode", 'e'));
    }

    public int[] shortestToChar(String S, char C) {
        List<Integer> shortestDistanceList = new ArrayList<>();
        List<Integer> indexList = getCharIndexList(S, C);
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (C == temp) {
                shortestDistanceList.add(0);
            } else {
                shortestDistanceList.add(getShortestDistance(i, indexList));
            }
        }
        int[] distanceArray = new int[shortestDistanceList.size()];
        for (int i = 0; i < shortestDistanceList.size(); i++) {
            distanceArray[i] = shortestDistanceList.get(i);
        }
        return distanceArray;
    }

    private Integer getShortestDistance(int i, List<Integer> indexList) {
        Integer shortestDistance = Integer.MAX_VALUE;
        for (Integer index : indexList
                ) {
            Integer distance = Math.abs(i - index);
            if (distance < shortestDistance) {
                shortestDistance = distance;
            }
        }
        return shortestDistance;
    }

    private List getCharIndexList(String s, char c) {
        List<Integer> indexList = new ArrayList<>();
        Integer index = s.indexOf(c);
        Integer tempIndex;
        while (index != -1 && index <= s.length() - 1) {
            indexList.add(index);
            tempIndex = s.indexOf(c,index+1);
            index=tempIndex;
        }
        return indexList;
    }
}
