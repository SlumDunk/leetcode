package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 09:57
 * @Description: Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 * <p>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given address is a valid IPv4 address.
 */
public class Leetcode1108 {
    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return address;
        }
        StringBuilder buffer = new StringBuilder();
        for (char c :
                address.toCharArray()) {
            if (c == '.') {
                buffer.append('[');
                buffer.append('.');
                buffer.append(']');
            } else {
                buffer.append(c);
            }
        }

        return buffer.toString();

    }
}
