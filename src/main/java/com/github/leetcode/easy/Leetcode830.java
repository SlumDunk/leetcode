package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 */
public class Leetcode830 {
    public static void main(String[] args) {
        Leetcode830 leetcode830 = new Leetcode830();
        leetcode830.largeGroupPositions("aaa");
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int i = 0;
        int startIndex = 0;
        char start = S.charAt(startIndex);
        List<Integer> positionList;
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        while (i < S.length() - 1) {
            if (S.charAt(i + 1) != start) {
                addToList(i, startIndex, resultList);
                startIndex = i + 1;
                start = S.charAt(startIndex);
            } else if (i + 1 == S.length() - 1) {
                addToList(i + 1, startIndex, resultList);
            }
            i++;
        }
        return resultList;
    }

    private void addToList(int i, int startIndex, List<List<Integer>> resultList) {
        List<Integer> positionList;
        if (i - startIndex >= 2) {
            positionList = new ArrayList<Integer>();
            positionList.add(startIndex);
            positionList.add(i);
            resultList.add(positionList);
        }
    }
}
