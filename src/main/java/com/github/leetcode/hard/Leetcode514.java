package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 12:53
 * @Description: In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.
 * <p>
 * Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.
 * <p>
 * Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button.
 * <p>
 * At the stage of rotating the ring to spell the key character key[i]:
 * <p>
 * You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
 * If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.
 * Example:
 * <p>
 * <p>
 * <p>
 * Input: ring = "godding", key = "gd"
 * Output: 4
 * Explanation:
 * For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
 * For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 * Also, we need 1 more step for spelling.
 * So the final output is 4.
 * Note:
 * <p>
 * Length of both ring and key will be in range 1 to 100.
 * There are only lowercase letters in both strings and might be some duplcate characters in both strings.
 * It's guaranteed that string key could always be spelled by rotating the string ring.
 */
public class Leetcode514 {

    public int findRotateSteps(String ring, String key) {
        char[] R = ring.toCharArray();
        char[] K = key.toCharArray();
        //记录各个字符出现的位置
        List<List<Integer>> P = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            P.add(new ArrayList<>());
        }
        for (int i = 0; i < R.length; i++) {
            P.get(R[i] - 'a').add(i);
        }

        // Bottom up DP
        // dp[k][r]: answer for substring [k, key.length-1] of K where R[p] is at 12:00,
        // space can be further optimized
        int[][] dp = new int[K.length + 1][R.length];
        //从后往前扫 key的字符
        for (int k = K.length - 1; k >= 0; k--) {
            //每个字符需要遍历一次ring中所有的字符，求出以当前r字符在12点位置时的相对距离
            for (int r = 0; r < R.length; r++) {
                int move = Integer.MAX_VALUE;
                //查找出ring中这次字符k的位置
                for (int p : P.get(K[k] - 'a')) {
                    int a1 = Math.max(p, r);
                    int a2 = Math.min(p, r);
                    //顺时针和逆时针，两种情况都考虑
                    move = Math.min(move, Math.min(a1 - a2, a2 - a1 + R.length) + dp[k + 1][p]);
                }
                //按一次button
                dp[k][r] = move + 1;
            }
        }

        return dp[0][0];
    }
}
