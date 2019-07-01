package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 21:23
 * @Description: During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're given n teams, you need to output their final contest matches in the form of a string.
 * <p>
 * The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition. During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 * <p>
 * Example 1:
 * Input: 2
 * Output: (1,2)
 * Explanation:
 * Initially, we have the team 1 and the team 2, placed like: 1,2.
 * Then we pair the team (1,2) together with '(', ')' and ',', which is the final answer.
 * Example 2:
 * Input: 4
 * Output: ((1,4),(2,3))
 * Explanation:
 * In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
 * And we got (1,4),(2,3).
 * In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
 * And we got the final answer ((1,4),(2,3)).
 * Example 3:
 * Input: 8
 * Output: (((1,8),(4,5)),((2,7),(3,6)))
 * Explanation:
 * First round: (1,8),(2,7),(3,6),(4,5)
 * Second round: ((1,8),(4,5)),((2,7),(3,6))
 * Third round: (((1,8),(4,5)),((2,7),(3,6)))
 * Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
 * Note:
 * The n is in range [2, 212].
 * We ensure that the input n can be converted into the form 2k, where k is a positive integer.
 */
public class Leetcode544 {
    public String findContestMatch(int n) {
        String[] arrays = new String[n];
        //初始化原始数组 1....n映射到下标0.....n-1
        for (int i = 1; i <= n; ++i) {
            arrays[i - 1] = String.valueOf(i);
        }
        return findContestMatchHelper(n, arrays);
    }

    /**
     * dfs 递归，每次折半成两个数组, 高低配对组合
     *
     * @param n      元素长度
     * @param arrays
     * @return
     */
    private String findContestMatchHelper(int n, String[] arrays) {
        while (arrays.length > 1) {
            String[] newStrs = new String[n / 2];
            for (int i = 0; i < n / 2; ++i) {
                newStrs[i] = "(" + arrays[i] + "," + arrays[n - i - 1] + ")";
            }
            n /= 2;
            arrays = newStrs;
        }
        return arrays[0];
    }
}
