package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 17:25
 * @Description: In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * <p>
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
 * <p>
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * <p>
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
 * <p>
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 * Note:
 * <p>
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * Any answer which has the same (highest) similarity as the best answer will be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7 characters.
 */
public class Leetcode800 {
    public String similarRGB(String color) {
        return "#" +
                closest[parseHex(color.charAt(1)) * 16 + parseHex(color.charAt(2))] +
                closest[parseHex(color.charAt(3)) * 16 + parseHex(color.charAt(4))] +
                closest[parseHex(color.charAt(5)) * 16 + parseHex(color.charAt(6))];
    }

    private static final String[] closest = {
            "00", "00", "00", "00", "00", "00", "00", "00", "00", "11", "11", "11", "11", "11", "11", "11",
            "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "22", "22", "22", "22", "22", "22",
            "22", "22", "22", "22", "22", "22", "22", "22", "22", "22", "22", "33", "33", "33", "33", "33",
            "33", "33", "33", "33", "33", "33", "33", "33", "33", "33", "33", "33", "44", "44", "44", "44",
            "44", "44", "44", "44", "44", "44", "44", "44", "44", "44", "44", "44", "44", "55", "55", "55",
            "55", "55", "55", "55", "55", "55", "55", "55", "55", "55", "55", "55", "55", "55", "66", "66",
            "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "66", "77",
            "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77", "77",
            "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88", "88",
            "88", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99", "99",
            "99", "99", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa",
            "aa", "aa", "aa", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb", "bb",
            "bb", "bb", "bb", "bb", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc",
            "cc", "cc", "cc", "cc", "cc", "dd", "dd", "dd", "dd", "dd", "dd", "dd", "dd", "dd", "dd", "dd",
            "dd", "dd", "dd", "dd", "dd", "dd", "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee",
            "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ff", "ff", "ff", "ff", "ff", "ff", "ff", "ff", "ff",
    };

    int parseHex(char c) {
        return c >= '0' && c <= '9' ? c - '0' : 10 + c - 'a';
    }
}
