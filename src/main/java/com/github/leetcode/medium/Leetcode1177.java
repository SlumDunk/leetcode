package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 21:53
 * @Description: Given a string s, we make queries on substrings of s.
 * <p>
 * For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter.
 * <p>
 * If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
 * <p>
 * Return an array answer[], where answer[i] is the result of the i-th query queries[i].
 * <p>
 * Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)
 * <p>
 * <p>
 * <p>
 * Example :
 * <p>
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0] : substring = "d", is palidrome.
 * queries[1] : substring = "bc", is not palidrome.
 * queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s only contains lowercase English letters.
 */
public class Leetcode1177 {
    public List canMakePaliQueries(String s, int[][] queries) {
        int[] cache = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            cache[i + 1] = cache[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (query[2] > 26) {
                ans.add(true);
            } else {
                int cnt = convert(cache[query[1] + 1] ^ cache[query[0]]);
                if (query[2] < cnt / 2) {
                    ans.add(false);
                } else {
                    ans.add(true);
                }
            }
        }
        return ans;
    }

    private int convert(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2;
            num /= 2;
        }
        return cnt;
    }
}
