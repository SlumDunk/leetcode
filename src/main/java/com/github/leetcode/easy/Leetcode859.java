package com.github.leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 09:19
 * @Description: Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class Leetcode859 {
    public static void main(String[] args) {

    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return Boolean.FALSE;
        } else {
            List<Character> arrayList1 = new ArrayList<Character>();
            List<Character> arrayList2 = new ArrayList<Character>();
            int len = A.length();
            for (int i = 0; i < len; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    arrayList1.add(A.charAt(i));
                    arrayList2.add(B.charAt(i));
                }
            }
            if (arrayList1.size() == arrayList2.size() && arrayList1.size() == 2) {
                if (arrayList1.get(1) == arrayList2.get(0) && arrayList1.get(0) == arrayList2.get(1)) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } else {
                if (arrayList1.size() == 0 && arrayList2.size() == 0) {
                    Set<Character> set = new HashSet<Character>();
                    for (int i = 0; i < len; i++) {
                        if (set.contains(A.charAt(i))) {
                            return Boolean.TRUE;
                        } else {
                            set.add(A.charAt(i));
                        }
                    }
                    return Boolean.FALSE;
                } else {
                    return Boolean.FALSE;
                }
            }

        }
    }
}
