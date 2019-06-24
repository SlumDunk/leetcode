package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/5/19 21:58
 * @Description: You want to form a target string of lowercase letters.
 * <p>
 * At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.
 * <p>
 * On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.
 * <p>
 * For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)
 * <p>
 * If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
 * <p>
 * For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
 * <p>
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stamp = "abc", target = "ababc"
 * Output: [0,2]
 * ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 * Example 2:
 * <p>
 * Input: stamp = "abca", target = "aabcaca"
 * Output: [3,0,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stamp.length <= target.length <= 1000
 * stamp and target only contain lowercase letters.
 */
public class Leetcode936 {

    public static void main(String[] args) {
        Leetcode936 leetcode936 = new Leetcode936();
        leetcode936.movesToStamp("abca", "aabcaca");
    }

    /**
     * The idea is the same as the most upvoted post. Think reversely!
     * Let's take an example to illustrate.
     * Stamp = "abc", Target = "ababcbc`
     * <p>
     * Target = ab***bc
     * Target = ab*****
     * Target = *******
     * We will go through the whole Target string to find if there exists any substring equals to Stamp. And then replace the whole substring with *. You can see in the step 1, we replace substring abc with ***. Then we keep doing the same thing. In the step 2, you will find we replace substring *bc to ***. * can match to any character because * will be override by the next stamp. Finally we get the result and output the reversed result. When # of stars equals to target.length(), we will return the result. If during one scan, we are not able to replace even one substring with *, directly return empty array.
     * <p>
     * Comments for two helper functions:
     * canReplace(char[] T, int p, char[] S) is used to check if any substring from Target is existing to be replaced with *.
     * doReplace(char[] T, int p, int len, int count) is used to replace the substring with * and return the total number of * we have now.
     *
     * @param stamp
     * @param target
     * @return
     */
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[t.length];
        int stars = 0;
        while (stars < t.length) {
            boolean doneReplace = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && canReplace(t, i, s)) {
                    stars = doReplace(t, i, s.length, stars);
                    doneReplace = true;
                    visited[i] = true;
                    res.add(i);
                    if (stars == t.length) {
                        break;
                    }
                }
            }
            if (!doneReplace) {
                return new int[0];
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(res.size() - i - 1);
        }
        return resArray;
    }

    /**
     * 执行替换动作
     *
     * @param t
     * @param p
     * @param length
     * @param stars
     * @return
     */
    private int doReplace(char[] t, int p, int length, int stars) {
        for (int i = 0; i < length; i++) {
            if (t[i + p] != '*') {
                t[i + p] = '*';
                stars++;
            }
        }
        return stars;
    }

    /**
     * 判断能否替换
     *
     * @param t
     * @param p 开始位置
     * @param s
     * @return
     */
    private boolean canReplace(char[] t, int p, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + p] != '*' && t[i + p] != s[i]) {
                return false;
            }
        }
        return true;
    }
}
