package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 09:35
 * @Description: Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:
 * <p>
 * Each a_i is a non-empty string;
 * Their concatenation a_1 + a_2 + ... + a_k is equal to text;
 * For all 1 <= i <= k,  a_i = a_{k+1 - i}.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "ghiabcdefhelloadamhelloabcdefghi"
 * Output: 7
 * Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
 * Example 2:
 * <p>
 * Input: text = "merchant"
 * Output: 1
 * Explanation: We can split the string on "(merchant)".
 * Example 3:
 * <p>
 * Input: text = "antaprezatepzapreanta"
 * Output: 11
 * Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
 * Example 4:
 * <p>
 * Input: text = "aaa"
 * Output: 3
 * Explanation: We can split the string on "(a)(a)(a)".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * text consists only of lowercase English characters.
 * 1 <= text.length <= 1000
 */
public class Leetcode1147 {
    public int longestDecomposition(String text) {
        int chunkCount = 0;
        String left = "", right = "";
        int i = 0, j = text.length() - 1;
        while (i < j) {
            left = left + text.substring(i, i + 1);
            right = right + text.substring(j, j + 1);
            if (left.equals(new StringBuilder(right).reverse().toString())) {
                chunkCount += 2;
                left = "";
                right = "";
            }
            ++i;
            --j;
        }
        //有剩余
        if ((!left.equals("") && !right.equals("")) || i == j) // The left over m,iddle chunk
            ++chunkCount;
        return chunkCount;
    }
}
