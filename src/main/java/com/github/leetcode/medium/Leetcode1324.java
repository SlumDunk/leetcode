package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
 * Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will be only one word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "HOW ARE YOU"
 * Output: ["HAY","ORO","WEU"]
 * Explanation: Each word is printed vertically.
 * "HAY"
 * "ORO"
 * "WEU"
 * Example 2:
 * <p>
 * Input: s = "TO BE OR NOT TO BE"
 * Output: ["TBONTB","OEROOE","   T"]
 * Explanation: Trailing spaces is not allowed.
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * Example 3:
 * <p>
 * Input: s = "CONTEST IS COMING"
 * Output: ["CIC","OSO","N M","T I","E N","S G","T"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 200
 * s contains only upper case English letters.
 * It's guaranteed that there is only one space between 2 words.
 */
public class Leetcode1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word :
                words) {
            maxLen = Math.max(word.length(), maxLen);
        }
        List<String> ans = new ArrayList<>();
        int index = 0;
        while (index < maxLen) {
            StringBuilder temp = new StringBuilder("");
            for (String word :
                    words) {
                char character = word.length() > index ? word.charAt(index) : ' ';
                temp.append(character);
            }
            if (temp.charAt(temp.length() - 1) != ' ') {
                ans.add(temp.toString());
            } else {
                while (temp.charAt(temp.length() - 1) == ' ') {
                    temp.deleteCharAt(temp.length() - 1);
                }
                ans.add(temp.toString());
            }
            index++;
        }

        return ans;
    }
}
