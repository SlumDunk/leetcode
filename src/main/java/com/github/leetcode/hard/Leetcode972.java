package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 21:10
 * @Description: Given two strings S and T, each of which represents a non-negative rational number, return True if and only if they represent the same number. The strings may use parentheses to denote the repeating part of the rational number.
 * <p>
 * In general a rational number can be represented using up to three parts: an integer part, a non-repeating part, and a repeating part. The number will be represented in one of the following three ways:
 * <p>
 * <IntegerPart> (e.g. 0, 12, 123)
 * <IntegerPart><.><NonRepeatingPart>  (e.g. 0.5, 1., 2.12, 2.0001)
 * <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)> (e.g. 0.1(6), 0.9(9), 0.00(1212))
 * The repeating portion of a decimal expansion is conventionally denoted within a pair of round brackets.  For example:
 * <p>
 * 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66)
 * <p>
 * Both 0.1(6) or 0.1666(6) or 0.166(66) are correct representations of 1 / 6.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "0.(52)", T = "0.5(25)"
 * Output: true
 * Explanation:
 * Because "0.(52)" represents 0.52525252..., and "0.5(25)" represents 0.52525252525..... , the strings represent the same number.
 * Example 2:
 * <p>
 * Input: S = "0.1666(6)", T = "0.166(66)"
 * Output: true
 * Example 3:
 * <p>
 * Input: S = "0.9(9)", T = "1."
 * Output: true
 * Explanation:
 * "0.9(9)" represents 0.999999999... repeated forever, which equals 1.  [See this link for an explanation.]
 * "1." represents the number 1, which is formed correctly: (IntegerPart) = "1" and (NonRepeatingPart) = "".
 * <p>
 * <p>
 * Note:
 * <p>
 * Each part consists only of digits.
 * The <IntegerPart> will not begin with 2 or more zeros.  (There is no other restriction on the digits of each part.)
 * 1 <= <IntegerPart>.length <= 4
 * 0 <= <NonRepeatingPart>.length <= 4
 * 1 <= <RepeatingPart>.length <= 4
 */
public class Leetcode972 {
    private static class Parsed {
        int integer;
        //小数非重复部分
        int a;
        //小数重复部分
        int b;
        int baseA = 1;
        int baseB = 9;

        static Parsed of(String val) {
            Parsed out = new Parsed();
            int dotIndex = val.indexOf(".");
            if (dotIndex == -1) {//只有整数
                out.integer = Integer.parseInt(val);
            } else {
                out.integer = Integer.parseInt(val.substring(0, dotIndex));
                if (!val.endsWith(")")) {//没有重复
                    String nonRepeating = val.substring(dotIndex + 1);
                    applyA(nonRepeating, out);
                } else {//有重复
                    int openBraceIndex = val.indexOf("(");
                    applyA(val.substring(dotIndex + 1, openBraceIndex), out);
                    applyB(val.substring(openBraceIndex + 1, val.length() - 1), out);
                }
            }
            return out;
        }

        /**
         * 解析出小数非重复部分
         *
         * @param str
         * @param p
         */
        static void applyA(String str, Parsed p) {
            if (!"".equals(str)) {
                p.a = Integer.parseInt(str);
                p.baseA = (int) Math.pow(10, str.length());
            }
        }

        /**
         * 解析出小数重复部分
         *
         * @param str
         * @param p
         */
        static void applyB(String str, Parsed p) {
            p.b = Integer.parseInt(str);
            p.baseB = (int) Math.pow(10, str.length()) - 1;
        }

        /**
         * 计算出字符串表示的值
         *
         * @param p2
         * @return
         */
        long cal(Parsed p2) {
            return (integer * baseA * baseB + a * baseB + b) * p2.baseA * p2.baseB;
        }
    }


    public boolean isRationalEqual(String S, String T) {
        Parsed p1 = Parsed.of(S);
        Parsed p2 = Parsed.of(T);
        return p1.cal(p2) == p2.cal(p1);
    }
}
