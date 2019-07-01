package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 21:33
 * @Description: We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.
 * <p>
 * We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.
 * <p>
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.
 * <p>
 * Return true if we can build the pyramid all the way to the top, otherwise false.
 * <p>
 * Example 1:
 * <p>
 * Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 * A
 * / \
 * G   E
 * / \ / \
 * B   C   D
 * <p>
 * We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 * <p>
 * <p>
 * Note:
 * <p>
 * bottom will be a string with length in range [2, 8].
 * allowed will have length in range [0, 200].
 * Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class Leetcode756 {
    String[] letter = new String[]{"A", "B", "C", "D", "E", "F", "G"};

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashSet<String> set = new HashSet<>();
        for (String s : allowed) set.add(s);
        return helper(set, bottom, "", 0);
    }

    /**
     * @param set    允许的组合
     * @param bottom 当前层的 String
     * @param next   未来上一层的 String
     * @param start  开始位置
     * @return
     */
    private boolean helper(HashSet<String> set, String bottom, String next, int start) {
        //修到顶
        if (bottom.length() == 1) return true;
        if (start == bottom.length() - 1) {//递归处理上一层
            return helper(set, next, "", 0);
        }
        //子节点组合
        String t = bottom.substring(start, start + 2);
        for (int j = 0; j < letter.length; j++) {
            //不满足allowed
            if (!set.contains(t + letter[j])) continue;
            //递归
            if (helper(set, bottom, next + letter[j], start + 1)) {
                return true;
            }
        }
        return false;
    }
}
