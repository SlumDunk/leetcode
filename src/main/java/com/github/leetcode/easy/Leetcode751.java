package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 09:30
 * @Description: Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.
 * <p>
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.
 * <p>
 * Example 1:
 * Input: ip = "255.0.0.7", n = 10
 * Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 * Explanation:
 * The initial ip address, when converted to binary, looks like this (spaces added for clarity):
 * 255.0.0.7 -> 11111111 00000000 00000000 00000111
 * The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just this one address.
 * <p>
 * The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
 * 255.0.0.8 -> 11111111 00000000 00000000 00001000
 * Addresses with common prefix of 29 bits are:
 * 11111111 00000000 00000000 00001000
 * 11111111 00000000 00000000 00001001
 * 11111111 00000000 00000000 00001010
 * 11111111 00000000 00000000 00001011
 * 11111111 00000000 00000000 00001100
 * 11111111 00000000 00000000 00001101
 * 11111111 00000000 00000000 00001110
 * 11111111 00000000 00000000 00001111
 * <p>
 * The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just 11111111 00000000 00000000 00010000.
 * <p>
 * In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .
 * <p>
 * There were other representations, such as:
 * ["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
 * but our answer was the shortest possible.
 * <p>
 * Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
 * because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100
 * that are outside the specified range.
 * Note:
 * ip will be a valid IPv4 address.
 * Every implied address ip + x (for x < n) will be a valid IPv4 address.
 * n will be an integer in the range [1, 1000].
 */
public class Leetcode751 {
    /**
     * I don't think this is an easy problem, it contains much fundamental knowledge we don't deal with on a daily basis.
     * <p>
     * You should know about one’s complement(反码) and two's complement(补码)
     * https://stackoverflow.com/questions/2604296/twos-complement-why-the-name-two
     * (-x) is the two’s complement of x. (-x) will be equal to one’s complement of x plus 1.
     * for example:
     * <p>
     * 7  in binary              :  00000111
     * one’s complement of 7     :  11111000
     * two's complement of 7     :  11111001
     * x & (-x) of 7             :  00000001
     * So the value of x & (-x) can mean for 255.0.0.7, how many more ips we can represent in CIDR. In this case it's only 1.(because x & (-x) of 7 is 1)
     * for example, 255.0.0.8, x & (-x) of it is 00001000, it's 8, we can represent 8 more ips which start from it.
     * for 255.0.0.9, x & (-x) of it is 00000001, 1 again.
     * So for input: 255.0.0.7 and 10 ips, we should have results:
     * <p>
     * 255.0.0.7:1
     * 255.0.0.8:8
     * 255.0.0.9:1
     * But the specification of CIDR asks us to use a mask instead of count. So we transfer it to mask, it's the function oneCIDR has done.
     * I comment some code you need to pay more attention.
     *
     * @param ip
     * @param n
     * @return
     */
    public List<String> ipToCIDR(String ip, int n) {
        long x = 0;
        String[] parts = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            x = x << 8 + Long.parseLong(parts[i]);
        }

        List<String> res = new ArrayList<>();
        while (n > 0) {
            long count = x & -x;
            while (count > n) {
                count /= 2;
            }

            res.add(oneCIDR(x, count));
            n = n - (int) count;
            x = x + (int) count;
        }

        return res;
    }

    /**
     * 数字转ip
     *
     * @param x
     * @param count
     * @return
     */
    private String oneCIDR(long x, long count) {
        int d, c, b, a;
        d = (int) x & 255;
        x >>= 8;
        c = (int) x & 255;
        x >>= 8;
        b = (int) x & 255;
        x >>= 8;
        a = (int) x & 255;

        int len = 0;
        while (count > 0) {
            count >>= 1;
            len++;
        }
        //common prefix
        int mask = 32 - (len - 1);

        return new StringBuilder()
                .append(a)
                .append(".")
                .append(b)
                .append(".")
                .append(c)
                .append(".")
                .append(d)
                .append("/")
                .append(mask)
                .toString();
    }
}
