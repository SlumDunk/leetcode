package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 16:42
 * @Description: You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 */
public class Leetcode299 {
    public String getHint(String secret, String guess) {
        //存储两个数组各个数字不一致的数量
        int[] s = new int[10];
        int[] g = new int[10];

        //寻找位置相同，数字相同的字符个数
        int bull = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }

        //寻找位置不同，数字相同的字符个数
        int cow = 0;
        for (int i = 0; i < 10; i++) {
            cow += Math.min(s[i], g[i]);
        }

        return bull + "A" + cow + "B";
    }

}
