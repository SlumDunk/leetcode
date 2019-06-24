package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 20:21
 * @Description: Special binary strings are binary strings with the following two properties:
 * <p>
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)
 * <p>
 * At the end of any number of moves, what is the lexicographically largest resulting string possible?
 * <p>
 * Example 1:
 * Input: S = "11011000"
 * Output: "11100100"
 * Explanation:
 * The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
 * This is the lexicographically largest string possible after some number of swaps.
 * Note:
 * <p>
 * S has length at most 50.
 * S is guaranteed to be a special binary string as defined above.
 */
public class Leetcode761 {
    public static void main(String[] args) {
        Leetcode761 leetcode761 = new Leetcode761();
        leetcode761.makeLargestSpecial("11011000");
    }

    /**
     * (()(()))
     * ((())())
     * 1代表(, 0代表)
     *
     * @param S
     * @return
     */
    public String makeLargestSpecial(String S) {
        if (S == null || S.length() <= 2) return S;

        Stack<List<String>> nodes = new Stack<>();
        nodes.push(new ArrayList<>());

        for (char c : S.toCharArray()) {
            if (c == '1') {
                nodes.push(new ArrayList<>());
            } else {
                List<String> list = nodes.pop();
                sortStr(list);
                //配对完就能放入下一level
                nodes.peek().add("1" + getStr(list) + "0");
            }
        }
        //把能够配对的放进栈顶的list
        List<String> list = nodes.peek();
        sortStr(list);
        return getStr(list);
    }

    /**
     * 倒序排列
     *
     * @param list
     */
    private void sortStr(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    /**
     * 获取list串
     *
     * @param list
     * @return
     */
    private String getStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
