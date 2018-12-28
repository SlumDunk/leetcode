package com.github.leetcode.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 11:18
 * @Description: Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 我们可以知道第一个数字的长度不应该超过字符串长度的一般，第二个数字的长度无法超过字符串长度减去第一个数字的长度。
 */
public class Leetcode306 {
    public static void main(String[] args) {
        Leetcode306 leetcode306 = new Leetcode306();
        leetcode306.isAdditiveNumber("199100199");
    }


    public boolean isAdditiveNumber(String num) {
        return backTrack(num, new ArrayList<BigInteger>());
    }

    /**
     * @param remain 剩余字符串
     * @param cur    当前数字list
     * @return
     */
    public boolean backTrack(String remain, List<BigInteger> cur) {
        if (remain.length() == 0) {
            return cur.size() >= 3;
        }
        if (cur.size() < 2) {//少于两个数字
            for (int i = 0; i < remain.length(); ++i) {
                //构造数字
                String part = remain.substring(0, i + 1);
                if (part.length() > 1 && part.startsWith("0")) {  // no leading zero
                    continue;
                }
                //数字加入集合中
                cur.add(new BigInteger(part));
                if (backTrack(remain.substring(i + 1), cur)) {
                    return true;
                }
                //数字从集合中移除
                cur.remove(cur.size() - 1);
            }
        } else {
            //获取下一个要找的字符串，应该等于前面两个数字的和
            BigInteger nextval = cur.get(cur.size() - 1).add(cur.get(cur.size() - 2));
            String next = String.valueOf(nextval);
            //以和值开头，符合条件
            if (remain.startsWith(next)) {
                //添加到结果集
                cur.add(nextval);
                if (backTrack(remain.substring(next.length()), cur)) {
                    return true;
                }
                //从结果集中移除
                cur.remove(cur.size() - 1);
            }
        }
        return false;
    }


//    public boolean isAdditiveNumber(String s) {
//        int n = s.length();
//        for (int i = 1; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                long a = parse(s.substring(0, i));
//                long b = parse(s.substring(i, j));
//                if (a == -1 || b == -1) {
//                    continue;
//                } else {
//                    if (backTrack(s.substring(j), a, b)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    /**
     * @param s 剩下的字符串
     * @param a 左factor
     * @param b 右factor
     * @return
     */
//    boolean backTrack(String s, long a, long b) {
//        if (s.length() == 0) return true;
//
//        for (int i = 1; i <= s.length(); i++) {
//            long c = parse(s.substring(0, i));
//            if (c == -1) continue;
//            if (c == a + b) {
//                return backTrack(s.substring(i), b, c);
//            }
//        }
//        return false;
//    }

    /**
     * 字符串转成数字
     *
     * @param s
     * @return
     */
    long parse(String s) {
        if (!s.equals("0") && s.startsWith("0")) return -1;
        long result = 0;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
    }
}
