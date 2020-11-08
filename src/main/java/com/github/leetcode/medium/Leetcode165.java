package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 17:59
 * @Description: Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 */
public class Leetcode165 {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        //先对两个字符串进行切割，再进行比较
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int len1 = array1.length;
        int len2 = array2.length;

        int i = 0;
        while (i < len1 || i < len2) {
            int num1 = i < len1 ? Integer.parseInt(array1[i]) : 0;
            int num2 = i < len2 ? Integer.parseInt(array2[i]) : 0;
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            else i++;
        }

        return 0;
    }


    /**
     * O(n) n is the length of the longer string
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion_(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        //先对两个字符串进行切割，再进行比较
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int len1 = array1.length;
        int len2 = array2.length;

        int i = 0;
        while (i < len1 || i < len2) {
            Integer v1 = i >= len1 ? 0 : Integer.valueOf(array1[i]);
            Integer v2 = i >= len2 ? 0 : Integer.valueOf(array2[i]);
            i++;
            if (Integer.compare(v1, v2) == 0) {
                continue;
            } else {
                return Integer.compare(v1, v2);
            }

        }

        return 0;

    }
}
