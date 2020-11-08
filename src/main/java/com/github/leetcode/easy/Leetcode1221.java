package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 10/31/20 20:10
 * @Description: Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * <p>
 * Return the maximum amount of splitted balanced strings.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 * <p>
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 * <p>
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 * <p>
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 */
public class Leetcode1221 {
    public int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        int countL=0, countR=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='L'){
                countL++;
            }else{
                countR++;
            }
            if(countL==countR){
                ans++;
                countL=0;
                countR=0;
            }
        }
        return ans;
    }
}
