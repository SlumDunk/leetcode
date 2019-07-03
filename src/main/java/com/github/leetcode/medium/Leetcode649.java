package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 07:05
 * @Description: In the world of Dota2, there are two parties: the Radiant and the Dire.
 * <p>
 * The Dota2 senate consists of senators coming from two parties. Now the senate wants to make a decision about a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * <p>
 * Ban one senator's right:
 * A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory:
 * If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and make the decision about the change in the game.
 * <p>
 * <p>
 * Given a string representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party respectively. Then if there are n senators, the size of the given string will be n.
 * <p>
 * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * <p>
 * Suppose every senator is smart enough and will play the best strategy for his own party, you need to predict which party will finally announce the victory and make the change in the Dota2 game. The output should be Radiant or Dire.
 * <p>
 * Example 1:
 * <p>
 * Input: "RD"
 * Output: "Radiant"
 * Explanation: The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights any more since his right has been banned.
 * And in the round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "RDD"
 * Output: "Dire"
 * Explanation:
 * The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And the third senator comes from Dire and he can ban the first senator's right in the round 1.
 * And in the round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of the given string will in the range [1, 10,000].
 */
public class Leetcode649 {
    public String predictPartyVictory(String senate) {
        int countR = 0, countD = 0;
        char[] chars = senate.toCharArray();
        for (char c : chars) {
            if (c == 'R') countR++;
            else countD++;
        }

        while (countR != 0 && countD != 0) {
            int killR = 0, killD = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == ' ') continue;
                if (c == 'R') {
                    if (killR > 0) {//被对手干掉了
                        killR--;
                        chars[i] = ' ';
                        countR--;
                    } else {//保留权利
                        killD++;
                    }
                } else {
                    if (killD > 0) {//被对手干掉了
                        killD--;
                        chars[i] = ' ';
                        countD--;
                    } else {//保留权利
                        killR++;
                    }
                }
            }

            if (killD > 0) {
                //对冲
                for (int i = 0; i < chars.length && killD > 0; i++) {
                    if (chars[i] == 'D') {
                        chars[i] = ' ';
                        countD--;
                        killD--;
                    }
                }
            }
            if (killR > 0) {
                //对冲
                for (int i = 0; i < chars.length && killR > 0; i++) {
                    if (chars[i] == 'R') {
                        chars[i] = ' ';
                        countR--;
                        killR--;
                    }
                }
            }
        }

        if (countR > 0) return "Radiant";
        else return "Dire";
    }
}
