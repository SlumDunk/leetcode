package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 21:22
 * @Description: In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 * <p>
 * Example:
 * <p>
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Note:
 * <p>
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class Leetcode777 {
    /**
     * 两边都是以X为中心点
     *
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        for (int i = 0, j = 0, len = start.length(); i < len && j < len; i++, j++) {
            char s = start.charAt(i), e = end.charAt(j);
            while (s == 'X' && i < len - 1) s = start.charAt(++i);
            while (e == 'X' && j < len - 1) e = end.charAt(++j);
            if (s != e) return false;
            if ((s == 'R' && i > j) || (s == 'L' && i < j)) return false;
        }
        return true;
    }
}
