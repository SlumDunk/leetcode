package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 21:00
 * @Description: We are given N different types of stickers. Each sticker has a lowercase English word on it.
 * <p>
 * You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
 * <p>
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 * <p>
 * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * ["with", "example", "science"], "thehat"
 * Output:
 * <p>
 * 3
 * Explanation:
 * <p>
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target string.
 * Example 2:
 * <p>
 * Input:
 * <p>
 * ["notice", "possible"], "basicbasic"
 * Output:
 * <p>
 * -1
 * Explanation:
 * <p>
 * We can't form the target "basicbasic" from cutting letters from the given stickers.
 * Note:
 * <p>
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English letters.
 * In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
 * The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
 */
public class Leetcode691 {
    int[][] countMap; //map[i][j] means the number of character (j + 'a') contains in the ith element of stickers...
    int cnt = Integer.MAX_VALUE;

    public int minStickers(String[] stickers, String target) {
        if (target == null) return -1;
        if (target.length() == 0) return 0;
        if (stickers == null || stickers.length == 0) return -1;

        int m = stickers.length;
        countMap = new int[m][26];

        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                countMap[i][c - 'a']++;
            }
        }
        count(0, 0, new int[26], target, m, target.length());
        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }

    /**
     * @param curCnt
     * @param pos           目标字符的位置
     * @param charAvailable
     * @param target
     * @param m             sticker长度
     * @param n             目标单词的长度
     */
    private void count(int curCnt, int pos, int[] charAvailable, String target, int m, int n) {
        if (curCnt >= cnt) return; //prune the search, when curCnt will be larger then cnt...
        //important step... other wise will get TLE..
        if (pos == n) {
            cnt = Math.min(cnt, curCnt);
            return;
        }
        //当前字符
        char c = target.charAt(pos);
        if (charAvailable[c - 'a'] > 0) {
            charAvailable[c - 'a']--;
            count(curCnt, pos + 1, charAvailable, target, m, n);
            charAvailable[c - 'a']++;
        } else {
            for (int i = 0; i < m; i++) {//需要拆新的单词来填充
                if (countMap[i][c - 'a'] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    charAvailable[j] += countMap[i][j];
                }
                count(curCnt + 1, pos, charAvailable, target, m, n);
                for (int j = 0; j < 26; j++) {//backtrack
                    charAvailable[j] -= countMap[i][j];
                }
            }
        }
    }
}
