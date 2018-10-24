package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 16:27
 * @Description: Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 * <p>
 * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 * <p>
 * Corner Cases:
 * <p>
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Leetcode71 {

    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        int length = pathArray.length;
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < length; i++) {
            if (pathArray[i].equals("") || pathArray[i].equals(".")) {
            } else if (pathArray[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(pathArray[i]);
            }
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        return result;
    }


}
