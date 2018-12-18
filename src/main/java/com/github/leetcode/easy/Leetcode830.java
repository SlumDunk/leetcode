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
        //位置指针
        int index = 0;
        int startIndex = 0;
        //暂存要比较的字符
        char tmp = S.charAt(startIndex);
        //连续相同串的长度
        int size = 1;
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        while (index < S.length() - 1) {
            if (S.charAt(index + 1) != tmp) {//和下一个字符不同，需要变更
                if (size >= 3) {//判断长度是否大于等于3
                    addToList(index, startIndex, resultList);
                }
                startIndex = index + 1;//变更开始位置
                size = 1;//变更长度
                tmp = S.charAt(startIndex);//变更暂存的字符
            } else {//相同的情况，长度+1
                size++;
            }
            index++;
        }
        //防止漏掉最后一个串
        if (size >= 3) {
            addToList(index, startIndex, resultList);
        }
        return resultList;
    }

    /**
     * 将符合条件的组合添加到结果集
     *
     * @param endIndex
     * @param startIndex
     * @param resultList
     */
    private void addToList(int endIndex, int startIndex, List<List<Integer>> resultList) {
        List<Integer> positionList;
        positionList = new ArrayList<Integer>();
        positionList.add(startIndex);
        positionList.add(endIndex);
        resultList.add(positionList);
    }
}
