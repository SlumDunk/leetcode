package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/2/20 19:45
 * @Description: Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 * <p>
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * <p>
 * It's guaranteed that a unique mapping will always exist.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 * <p>
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 * <p>
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 * <p>
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 */
public class Leetcode1309 {
    public String freqAlphabets(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        //Traverse the string from behind and look for the '#'
        for (int i = len - 1; i >= 0; i--) {
            //If '#' not found convert it simply to the corresponding character
            if (s.charAt(i) != '#') {
                res.append((char) (s.charAt(i) + 48));
            } else {
                //If # found then use ASCII code to decode the characters
                //ASCII code for numbers is 48-57 (0-9)
                int temp;
                temp = (s.charAt(i - 1) - 48) + 10 * (s.charAt(i - 2) - 48) + 96;
                res.append((char) temp);
                temp = 0;
                //Skip the next two characters as we have already taken them into consideration
                i = i - 2;
            }
        }
        StringBuilder result = res.reverse();
        return result.toString();
    }
}
