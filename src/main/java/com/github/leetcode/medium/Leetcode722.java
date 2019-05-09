package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 09:08
 * @Description: Given a C++ program, remove comments from it. The program source is an array where source[i] is the i-th line of the source code. This represents the result of splitting the original source code string by the newline character \n.
 * <p>
 * In C++, there are two types of comments, line comments, and block comments.
 * <p>
 * The string // denotes a line comment, which represents that it and rest of the characters to the right of it in the same line should be ignored.
 * <p>
 * The string /* denotes a block comment, which represents that all characters until the next (non-overlapping) occurrence of
 */


public class Leetcode722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String line :
                source) {
            for (int i = 0; i < line.length(); i++) {
                if (mode) {
                    if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        mode = false;
                        i++;
                    }
                } else {
                    if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        break;
                    } else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
                        mode = true;
                        i++;
                    } else {
                        sb.append(sb.charAt(i));
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
